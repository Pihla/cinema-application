function getAndDisplaySeatInfo() {
    //code for making a http request from here: https://kinsta.com/knowledgebase/javascript-http-request/
    const xhr = new XMLHttpRequest();
    const numberOfSeats = document.getElementById("numberOfSeats").value;

    xhr.open("GET", "http://localhost:8080/seats?numberOfSeats="+numberOfSeats);
    xhr.send();
    xhr.responseType = "json";
    xhr.onload = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {

            //remove old seats
            const oldSeats = document.getElementsByTagName("div");
            while(oldSeats.length > 0){
                oldSeats[0].parentNode.removeChild(oldSeats[0]);
            }

            const data = xhr.response;

            var seatsDiv = document.createElement("div");
            data.forEach(row => {
                var rowElement = document.createElement("div");
                row.forEach(seat => {
                    var seatElement = document.createElement("div");
                    switch (seat.toString()) {
                        case "FREE":
                            seatElement.classList.add("freeSeat", "seat");
                            break;
                        case "TAKEN":
                            seatElement.classList.add("takenSeat", "seat");
                            break;
                        case "CHOSEN":
                            seatElement.classList.add("chosenSeat", "seat");
                            break;
                    }
                    rowElement.appendChild(seatElement);
                })
                seatsDiv.appendChild(rowElement);
            })


            /*const seatButton = document.createElement("button");
            seatButton.className = "ui button";
            const buttonTextNode = document.createTextNode("Get seat recommendation");
            seatButton.appendChild(buttonTextNode);*/


            document.body.insertBefore(seatsDiv, document.getElementById("change me")) //TODO change it

        } else {
            console.log(`Error: ${xhr.status}`);
        }
    };
}