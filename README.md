# CivSim
**PROSTA SYMULACJA ROZWOJU CYWILIZACJI**
---
Symulacja będzie polegała na rozwoju losowo rozrzuconych na wygenerowanej mapie określonej ilości cywilizacji. Zadaniem poszczególnej cywilizacji jest
zdobywanie zasobów w celu rozwoju oraz ekspansji.

Przed rozpoczęciem symulacji klient aplikacji podaje wielkość mapy, ilość
cywilizacji oraz czas trwania symulacji w dniach.

Aby rozwinąć się wioska zbiera zasoby z pól, na których się znajduje oraz z
im bezpośrednio sąsiadujących. Zbieranie surowców odbywać się będzie co turę.
Jedna tura będzie odpowiadać jednemu dniu.

Możliwe zasoby do zebrania to:

- drewno - wymagane jest do budowy i naprawy wioski oraz do tworzenia
jednostek handlowych
- zboża - wymagane jest do budowy wioski i rozbudowy jej w miasto
- zwierzęta hodowlane - wymagane są do zwiększania populacji oraz do
tworzenia jednostek handlowych
- kamienie - wymagane są do rozbudowy wioski w miasto oraz jego naprawy,
a także do tworzenia jednostek militarnych
- żelazo - wymagane jest do tworzenia jednostek militarnych

Po uzbieraniu odpowiedniej ilości zasobów mogą one zostać wykorzystane
na ekspansję danej cywilizacji, rozwój przejętych obszarów, zwiększanie ilości
mieszkańców lub stworzenie jednostek mobilnych.

Potencjalna cywilizacja po wyborze ekspansji terenów przejmuje jedno z sąsiadujących jej pól, jako kolejna część wioski. Na ten rozwój zostaną zużyte
odpowiednie, wcześniej uzbierane zasoby.

Rozwój terytorialny będzie ograniczony poprzez ilość ludności oraz stopień
zaawansowania cywilizacji. Po przejęciu pewnej ilości pól, wioska będzie zmuszona do ulepszenia statusu przynajmniej jednego z nich do poziomu miasta. Z
czasem sąsiadujące pola do miasta zmienią swój status na przedmieścia. Analogicznie ponownie po osiągnięciu limitu ekspansji wymagane będzie ulepszenie
statusu kolejnego pola, tym razem sąsiadującego z jednym z poprzednich pól
miasta. Pole miasta blokuje możliwość zbierania znajdujących się wcześniej na
nim zasobów.

**JEDNOSTKI MOBILNE**

Każda cywilizacja będzie miała możliwość tworzenia jednostek mobilnych.
Będą one w stanie przemieszczać się po mapie i każda z nich będzie miała
odmienne funkcje.

Jednostki mobilne będą oddzielną klasą, od której pewne właściwości będą
dziedziczyły jednostki militarne lub handlowe, takie jak życie obiektu lub możliwość poruszania się po mapie.

- Jednostki handlowe będą umożliwiać handel pomiędzy cywilizacjami. Będą one losowo poruszały się po mapie, do momentu, kiedy spotka inną
cywilizację. W tym momencie zostanie zawarty sojusz pomiędzy danymi
cywilizacjami, dzięki czemu możliwy będzie handel barterowy pomiędzy
nimi. Do momentu, kiedy ta jednostka nie umrze, dane cywilizacje będą
zaprzyjaźnione.
- Jednostki militarne będą w stanie poruszać się po określonym obszarze
wokół cywililizacji, który będzie się zwiększał, zależnie od rozwoju danej
cywilizacji, czyt. ilości zbudowanych miast. Będą atakować wrogie jednostki
militarne oraz jednostki handlowe nie należące do swojej lub zaprzyjaźnionej cywilizacji.

**ZDARZENIA LOSOWE**

Z czasem przebiegu symulacji będzie istniała szansa na pojawienie się zdarzeń
losowych:

- pożar - zdarzenie dotykające obszarów z zasobami typu: drewno lub miast
i wiosek. Pola z zasobami zostają zniszczone, a pola należące do cywilizacji
zostają uszkodzone.
- powódź - zdarzenie dotykające jakiegoś niewielkiego obszaru lub miast i
wiosek. Na polach neutralnych nałożony zostaje efekt restrykcji mobilności,
w wioskach zostaje nałożony efekt redukcji pozyskiwanych zasobów, a w
miastach zostaje nałożony efekt depopulacji.
- ulewa - zdarzenie dotykające jakiegoś niewielkiego obszaru, na którym
nałożony zostaje efekt redukcji mobilności.
- susza - zdarzenie dotykające jakiegoś większego obszaru, na który zostaje
nałożona redukcja pozyskiwania zasobów i trwa kilkanaście tur.
- choroba - początkowo zdarzenie pojawia się w wioskach i ma możliwość
przemieszczania się na sąsiadujące pola należące do cywilizacji. Na pola
dotknięte tym zdarzeniem nałożony zostaje efekt depopulacji.
- deszcz meteorytów - meteoryty losowo uderzają w pola na jakimś określonym obszarze przez kilka tur. Pola należące do cywilizacji zostają zniszczone. Pola zasobów mają zwiększoną szansę na pojawienie się pożaru.
- tornado - jest jednostką mobilną, która na określoną ilość tur przemierza
mapę po losowo określonej trasie. Po napotkaniu innych jednostek mobilnych, niszczy je. Jeśli trafi na wioskę, uszkadza ją. Jeśli trafi na miasto,
zostaje na nie nałożony efekt depopulacji.

**EFEKTY**

- uszkodzenie:
  - wioska - wymaga naprawy, by zdobywać zasoby
  - miasto - wymaga naprawy, by cywilizacja się rozwijała
- restrykcja mobilności - uniemożliwia przemieszczanie się jednostkom
mobilnym przez obszar dotknięty tym efektem
- redukcja mobilności - jednostki wchodzace na obszar dotkniętym tym
efektem tracą jedną turę, po czym znowu mogą się poruszać
- zniszczenie:
  - wioska - powoduje utracenie statusu wioski i wymagane jest ponowne
przejęcie pola
  - miasto - jego status zostaje zmniejszony do statusu wioski. Jeśli ilość
wiosek przekracza maksymalną ich ilość zależną od ilości miast, nadmiarowe wioski zostają uszkodzone
  - pole zasobów - zablokowana zostaje możliwość pozyskania zasobów z
tego obszaru na kilka tur
  - jednostki mobilne - zostają usunięte z mapy i wszelkie bonusy jakie
dawały zostają anulowane
- redukcja pozyskiwania zasobów - ilość pozyskiwanych zasobów zostaje
zmniejszona dwu lub trzykrotnie, w zależności od typu zasobów
- depopulacja - co turę stopniowo zmniejsza się liczba mieszkańców pola
dotkniętego tym efektem (miasto/wieś)



