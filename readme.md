Unrolled Linked List – tai Linked List variacija, kuri kiekviename mazge gali laikyti daugiau nei viena elementa ar objekta. Tai gali labai stipriai pagerinti kešavimo kokybe bei sumažinti papildoma atminti, skirta saugoti objekto metaduomenis, tokius kaip nuorodos. Del šios priežasties Unrolled Linked List talpa yra mažesne, nei Linked List. Unrolled Linked List, kiekviename mazge talpinantis N elementu, užims nuo (V / M + S)N iki (2V / M + S)N vietos, kai tuo tarpu iprastas Linked List sunaudoja (V + S)/N vietos. Cia V – papildoma atmintis, skiriama nuorodoms; M – maksimalus elementu mazge skaicius, S – vieno elemento dydis. 
Klaseje realizuojamas Add metodas. Jis vyksta taip:
1.	Jeigu klaseje nera jokiu mazgu, sukuriamas naujas (pirmasis) mazgas ir i ji irašomas elementas.
2.	Jeigu klaseje yra kitu mazgu, paimamas paskutinis, ir, jeigu jo elementu skaicius neviršina ~70 proc. Maksimalios talpos, i ta mazga irašomas paduotas elementas.
3.	Jeigu klaseje yra kitu mazgu ir paskutinis mazgas yra pilnas, jame paliekama ~70 proc. Duomenu, likusius perrašant i nauja mazga. I ta nauja mazga iterpiamas ir paduotas elementas.
Klaseje taip pat realizuojamas ir Remove metodas. Jo veikimas:
1.	Jeigu paduodamas tušcias elementas, pašalinimas nevykdomas.
2.	Jeigu paduodamas realus elementas, jis pašalinimas iš mazgo, kuriame jis yra patalpintas. Tuomet, jeigu tai nebuvo paskutinis sarašo mazgas, tikrinamas jo elementu kiekis. Jeigu jis yra mažesnis nei ~70 proc., i ji perrašomi sekancio mazgo duomenys tol, kol elementu kiekis pasiekia ~70 proc. Maksimalios elementu talpos. 
a.	Jeigu sekantis mazgas po elementu perrašymo taip pat turi mažiau nei 70 % elementu, jis yra suliejamas su mazgu, iš kurio buvo šalinamas elementas, ir pašalinamas iš sarašo.
3.	Jeigu paduodamas realus elementas, jis pašalinamas iš mazgo, ir, jeigu daugiau tame mazge neliko elementu, pašalinamas ir pats mazgas.
Kitu realizuotu metodu paaiškinimai:
1.	Destroy – pašalina nuoroda i sarašo pradžia, pabaiga, ir mazgu skaiciu nustato i 0. Tuomet Javos šiukšliu surinkejas pašalina visus nebenaudojamus mazgus automatiškai.
2.	DataSize – gražina elementu, patalpintu saraše, skaiciu
3.	Size – gražina mazgu skaiciu
4.	Contains – patikrina elemento priklausomuma sarašui

Tobulintinos vietos: 
•	Vietoje ArrayList<E> elementu masyvo, butu galima naudoti Object klases masyva.
•	Destroy metodo perrašymas

