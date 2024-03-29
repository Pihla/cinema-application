function getAndDisplayRecommendations() {
    getAndDisplayShowtimes("http://localhost:8080/showtimes/recommendations")
}

function getAndDisplayShowtimes(requestUrl="http://localhost:8080/showtimes") {
    //remove old boxes
    const oldShowtimes = document.getElementsByClassName("movieDiv");
    while(oldShowtimes.length > 0){
        oldShowtimes[0].parentNode.removeChild(oldShowtimes[0]);
    }

    //get showtimes from the server
    //code for making a http request from here: https://kinsta.com/knowledgebase/javascript-http-request/
    const xhr = new XMLHttpRequest();
    xhr.open("GET", requestUrl);
    xhr.send();
    xhr.responseType = "json";
    xhr.onload = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const data = xhr.response;
            data.forEach(displayShowtime);
        } else {
            console.log(`Error: ${xhr.status}`);
        }
    };
}

function getFormInfoAndDisplayShowtimes() {


    //compose url to get showtimes from server
    var genreValue = document.getElementById("genreSelect").value;
    var ageLimitValue = document.getElementById("ageLimitSelect").value;
    var languageValue = document.getElementById("languageSelect").value;
    var earliestStartHourValue = document.getElementById("earliestStartHourSelect").value;

    var requestUrl = "http://localhost:8080/showtimes?";
    if(genreValue !== "") {
        requestUrl += "genre=" + genreValue + "&";
    }
    if(ageLimitValue !== "") {
        requestUrl += "ageLimit=" + ageLimitValue + "&";
    }
    if(languageValue !== "") {
        requestUrl += "language=" + languageValue + "&";
    }
    if(earliestStartHourValue !== "") {
        requestUrl += "earliestStartHour=" + earliestStartHourValue + "&";
    }

    console.log(requestUrl);

    //TODO add min and max movie length

    getAndDisplayShowtimes(requestUrl);

}

function displayShowtime(showtime_JSON) {


    const movieDiv = document.createElement("div");
    movieDiv.className = "movieDiv item";

    const movieDivContentDiv = document.createElement("div");
    movieDivContentDiv.className = "content";

    const movieTitle = document.createTextNode(showtime_JSON["movie"]["name"])
    const movieTitleElement = document.createElement("p");
    movieTitleElement.className = "header";

    const genreTextNode = document.createTextNode(showtime_JSON["movie"]["genre"]);
    const ageLimitTextNode = document.createTextNode(showtime_JSON["movie"]["ageLimit"]);
    const timeInMinutesTextNode = document.createTextNode(showtime_JSON["movie"]["timeInMinutes"]);
    const showtimeTextNode = document.createTextNode(showtime_JSON["time"]);
    const languageTextNode = document.createTextNode(showtime_JSON["language"]);

    const movieInfo = document.createElement("div");
    movieInfo.className = "description";

    // add relationships between just created elements
    movieInfo.appendChild(genreTextNode);
    movieInfo.appendChild(document.createElement("br"));
    movieInfo.appendChild(ageLimitTextNode)
    movieInfo.appendChild(document.createElement("br"));
    movieInfo.appendChild(document.createElement("br"));
    movieInfo.appendChild(timeInMinutesTextNode);
    movieInfo.appendChild(document.createElement("br"));
    movieInfo.appendChild(showtimeTextNode);
    movieInfo.appendChild(document.createElement("br"));
    movieInfo.appendChild(languageTextNode);


    movieDiv.appendChild(movieDivContentDiv);
    movieDivContentDiv.appendChild(movieTitleElement);
    movieTitleElement.appendChild(movieTitle);
    movieDivContentDiv.appendChild(movieInfo);

    // add the newly created elements with their content into the DOM
    const showtimesDiv = document.getElementById("showtimes");
    const currentDiv = document.getElementById("div1");//TODO change element id
    showtimesDiv.insertBefore(movieDiv, currentDiv);



    //add button to get seat recommendation
    const seatButton = document.createElement("button");
    seatButton.className = "ui button";
    const buttonTextNode = document.createTextNode("Get seat recommendation");
    seatButton.appendChild(buttonTextNode);
    seatButton.onclick = function () {
        location.href = "/seats.html";
    };
    movieDiv.insertBefore(seatButton, document.getElementById("TODO change it"))//TODO change

}

