Pane kirja tööks kulunud aeg ja tee märkmeid selle kohta, mis oli keeruline. Kui jäid mõne probleemi
lahendamise puhul jänni, pane kirja, kust said abi ja kuidas probleemi lahendasid.

-------
# Eeldused
Rakendust kasutab ainult üks kasutaja (seega pole vaja andmebaasis kasutajaid eristada)



------------------------
# Tööprotsess ja raskused

## Projekti ülesseadmine - 1.5h
Kuna ma pole ise varem väga palju veebirakendusi üles seadnud ning Spring Bootiga on ka kogemus väike, siis oli see osa minu jaoks üsna raske. Tegin aga läbi mõned näited ja sain rakenduse tööle ning ühendatud ka andmebaasi ja front-endiga. Sain ka front-end raamistiku tööle. 

Projekti loomise ning HTTP-päringute saatmise kohta front-endi ja back-endi vahel sain abi siit: https://www.jetbrains.com/help/idea/your-first-spring-application.html.

Kohaliku andmebaasi ülesseadmise ja kasutamise kohta sain abi siit: https://spring.io/guides/gs/accessing-data-jpa.

Front-end raamistikuks valisin Semantic UI ning selle ZIP-faili laadisin alla siit: https://semantic-ui.com/introduction/getting-started.html. Panin failid resources/static kausta. Semantic UI kasutamise kohta sain abi dokumentatsioonist (nt nupu tegemise koodi kopeerisin siit: https://semantic-ui.com/elements/button.html).


## Filmide otsimise back-end - 2.5h + ???
Selle kohta, kuidas peaksid failid projektis paiknema, sain abi siit: https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819
Andmebaasist vajaliku info otsimise kohta sain abi siit: https://www.baeldung.com/spring-data-derived-queries, https://www.baeldung.com/spring-data-jpa-query ja SQL päringu koostamisel natuke ka ChatGPT-lt

Raskusi valmistas see, kuidas repository objekti controlleri klassis kasutada, aga lõpuks leidsin annotatsiooni Autowired: https://www.baeldung.com/spring-autowire