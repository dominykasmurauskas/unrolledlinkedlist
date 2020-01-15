Unrolled Linked List � tai Linked List variacija, kuri kiekviename mazge gali laikyti daugiau nei viena elementa ar objekta. Tai gali labai stipriai pagerinti ke�avimo kokybe bei suma�inti papildoma atminti, skirta saugoti objekto metaduomenis, tokius kaip nuorodos. Del �ios prie�asties Unrolled Linked List talpa yra ma�esne, nei Linked List. Unrolled Linked List, kiekviename mazge talpinantis N elementu, u�ims nuo (V / M + S)N iki (2V / M + S)N vietos, kai tuo tarpu iprastas Linked List sunaudoja (V + S)/N vietos. Cia V � papildoma atmintis, skiriama nuorodoms; M � maksimalus elementu mazge skaicius, S � vieno elemento dydis. 
Klaseje realizuojamas Add metodas. Jis vyksta taip:
1.	Jeigu klaseje nera jokiu mazgu, sukuriamas naujas (pirmasis) mazgas ir i ji ira�omas elementas.
2.	Jeigu klaseje yra kitu mazgu, paimamas paskutinis, ir, jeigu jo elementu skaicius nevir�ina ~70 proc. Maksimalios talpos, i ta mazga ira�omas paduotas elementas.
3.	Jeigu klaseje yra kitu mazgu ir paskutinis mazgas yra pilnas, jame paliekama ~70 proc. Duomenu, likusius perra�ant i nauja mazga. I ta nauja mazga iterpiamas ir paduotas elementas.
Klaseje taip pat realizuojamas ir Remove metodas. Jo veikimas:
1.	Jeigu paduodamas tu�cias elementas, pa�alinimas nevykdomas.
2.	Jeigu paduodamas realus elementas, jis pa�alinimas i� mazgo, kuriame jis yra patalpintas. Tuomet, jeigu tai nebuvo paskutinis sara�o mazgas, tikrinamas jo elementu kiekis. Jeigu jis yra ma�esnis nei ~70 proc., i ji perra�omi sekancio mazgo duomenys tol, kol elementu kiekis pasiekia ~70 proc. Maksimalios elementu talpos. 
a.	Jeigu sekantis mazgas po elementu perra�ymo taip pat turi ma�iau nei 70 % elementu, jis yra suliejamas su mazgu, i� kurio buvo �alinamas elementas, ir pa�alinamas i� sara�o.
3.	Jeigu paduodamas realus elementas, jis pa�alinamas i� mazgo, ir, jeigu daugiau tame mazge neliko elementu, pa�alinamas ir pats mazgas.
Kitu realizuotu metodu paai�kinimai:
1.	Destroy � pa�alina nuoroda i sara�o prad�ia, pabaiga, ir mazgu skaiciu nustato i 0. Tuomet Javos �iuk�liu surinkejas pa�alina visus nebenaudojamus mazgus automati�kai.
2.	DataSize � gra�ina elementu, patalpintu sara�e, skaiciu
3.	Size � gra�ina mazgu skaiciu
4.	Contains � patikrina elemento priklausomuma sara�ui

Tobulintinos vietos: 
�	Vietoje ArrayList<E> elementu masyvo, butu galima naudoti Object klases masyva.
�	Destroy metodo perra�ymas

