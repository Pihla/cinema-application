# Rakenduse kasutamine
Rakenduse kasutamiseks tuleb Spring Booti projekt käima panna ning minna brauseris aadressile http://localhost:8080/index.html

-------
# Eeldused, mida tegin ülesande kirjelduse põhjal
* Rakendust kasutab ainult üks kasutaja (seega pole vaja andmebaasis kasutajaid eristada).
* Istekohtade info genereeritakse iga kord juhuslikult ja seda pole vaja salvestada.
* Istekohti ei pea kasutaja saama ise valida. Ta peab lihtsalt nägema soovitust.

------------------------
# Tööprotsess ja raskused
Kokku kulus projektile umbes 11 tundi. Minu jaoks oli kõige raskem algne projekti ülesseadmine ning kasutajaliidese tegemine.

## Projekti ülesseadmine - 1.5h
Kuna ma pole ise varem väga palju veebirakendusi üles seadnud ning Spring Bootiga on ka kogemus väike, siis oli see osa minu jaoks üsna raske. Tegin aga läbi mõned näited ja sain rakenduse tööle ning ühendatud ka andmebaasi ja front-endiga. Sain ka front-end raamistiku tööle. 

Projekti loomise ning HTTP-päringute saatmise kohta front-endi ja back-endi vahel sain abi siit: https://www.jetbrains.com/help/idea/your-first-spring-application.html.

Kohaliku andmebaasi ülesseadmise ja kasutamise kohta sain abi siit: https://spring.io/guides/gs/accessing-data-jpa.

Front-end raamistikuks valisin Semantic UI ning selle ZIP-faili laadisin alla siit: https://semantic-ui.com/introduction/getting-started.html. Panin failid resources/static kausta. Semantic UI kasutamise kohta sain abi dokumentatsioonist (nt nupu tegemise koodi kopeerisin siit: https://semantic-ui.com/elements/button.html).


## Filmide otsimise back-end - 3h
Selle kohta, kuidas peaksid failid projektis paiknema, sain abi siit: https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819.
Andmebaasist vajaliku info otsimise kohta sain abi siit: https://www.baeldung.com/spring-data-derived-queries, https://www.baeldung.com/spring-data-jpa-query ja SQL päringu koostamisel natuke ka ChatGPT-lt

Raskusi valmistas see, kuidas repository objekti controlleri klassis kasutada, aga lõpuks leidsin annotatsiooni Autowired: https://www.baeldung.com/spring-autowire.

## Filmide otsimise front-end - 2.5h
HTTP-päringute tegemise kohta sain abi siit: https://kinsta.com/knowledgebase/javascript-http-request/.
JavaScriptis HTML-elementide muutmise kohta sain abi siit: https://developer.mozilla.org/en-US/docs/Web/API/Document/createElement.
Kasutasin Semantic UI dokumentatsiooni ning guugeldasin ka mõningaid teisi pisiasju, aga sellistel juhtudel kopeerisin maksimaalselt ühe rea, nii et ma ei hakka neid kõiki allikaid siia kirja panema.


## Filmide soovitamine (back-end ja front-end) - 40 min
Semantic UI dokumentatsiooni ning väikese guugeldamisega sain kõik lihtsasti tehtud.

## Istekohtade soovitamine (back-end ja front-end) - 3h
Semantic UI dokumentatsiooni ning väikese guugeldamisega sain kõik lihtsasti tehtud. Istekohtade soovitamise algoritmi välja mõtlemine võttis küll veidi aega, kuid sain selle oma peaga tehtud.


----
# Mis jäi tegemata
* Jäi panemata kasutajaliidesesse minimaalse ja maksimaalse filmi pikkuse filtrite valimine. Selle implementeerimiseks tuleb teha html elemendid ning JavaScriptis need samuti GET-päringusse sisse panna.
* Kasutajaliidese disain jäi poolikuks. Tuleks CSS-faile muuta, et elementidele soovitud stiile rakendada.
* Kasutajaliidese pealehel kuvatakse filmide info inglise keeles ja mitte kasutajasõbralikult. Tuleks muuta index.js failis info kuvamist.
* index.js failis võiks teha koodi kergemini loetavaks, grupeerides paremini ridu ning kasutades kommentaare.

