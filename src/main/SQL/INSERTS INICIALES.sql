--INSERTS USUARIOS
INSERT INTO USERS (UNAME, USERNAME, UPASSWORD, UROLE) VALUES ('Dani','HoleW','4852','DEV');
INSERT INTO USERS (UNAME, USERNAME, UPASSWORD, UROLE) VALUES ('Dani','USERTEST','1234','DEV');
INSERT INTO USERS (UNAME, USERNAME, UPASSWORD, UROLE) VALUES ('Archie','Doggie','2506','US');
INSERT INTO USERS (UNAME, USERNAME, UPASSWORD, UROLE) VALUES ('John','Doe','1111','US');



--INSERTS RESTAURANTES
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('1','Bajo el mar', 'Atlantida', '5');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('2','La alacena', 'España', '3');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('3','Rompevientos', 'Australia', '4');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('4','Anhelo', 'Estonia', '2');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('5','Aromaflor', 'Suiza', '5');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('6','Nevasca', 'Tokio', '1');
INSERT INTO RESTAURANTS (ID_RESTAURANT, NAME, NATION, STARS) VALUES ('7','Relleno nebuloso', 'Italia', '3');



--INSERTS PLATOS
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Arroz caldoso', '1', 'vegetariano', '6.70');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Lentejas', '2', 'Contiene carne', '7.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Cocido', '3', 'Contiene carne', '7.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Croquetas', '4', 'Contiene carne', '4.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Ensalada de la huerta', '5', 'vegetariano', '8.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Chipirones a la plancha', '6', 'Contiene carne', '8.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Patatas a la importancia', '7', 'vegetariano', '7.50');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Tortilla de patatas', '1', 'vegetariano', '5.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Huevos rotos con longaniza', '2', 'Contiene carne', '5.50');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Guisantes con jamon', '3', 'Contiene carne', '6.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Pollo al limon', '4', 'Contiene carne', '7.90');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Ramen a la suiza', '5', 'Contiene carne', '10.50');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Merluza en tempura', '6', 'Contiene carne', '12.00');
INSERT INTO DISHES (DNAME, ID_RESTAURANT, DTYPE, PRICE) VALUES ('Hamburguesa vegetariana', '7', 'vegetariano', '8.00');

--INSERTS PEDIDOS
--Lo ideal es no tener pedidos inicialmente
INSERT INTO ORDERS (ID_USER, ID_RESTAURANT, ID_DISH) VALUES ('1', '1', '1');