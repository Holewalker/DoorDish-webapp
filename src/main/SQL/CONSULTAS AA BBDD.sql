------------------------------------------------------------------------------------------------------------------------------------------------------
-----Crear una consulta de inserción de la información en una tabla cualquiera.
------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE INSERTAR_RESTAURANTE(IN_NAME IN VARCHAR, IN_NATION IN VARCHAR, IN_STARS IN VARCHAR) AS
BEGIN
    INSERT INTO restaurants (name, Nation, stars) VALUES (IN_NAME, IN_NATION, IN_STARS);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN 
        ROLLBACK;
END;
/

EXECUTE INSERTAR_RESTAURANTE('Sobre el mar','España','5');

------------------------------------------------------------------------------------------------------------------------------------------------------
-----Crear una consulta de actualización de la información de una tabla cualquiera. (modificar nombre/Tipo y precio buscando por nombre)
------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE ACTUALIZAR_PLATO(IN_NEWDNAME IN VARCHAR, IN_DTYPE IN VARCHAR, IN_PRICE IN VARCHAR, IN_DNAME IN VARCHAR) AS
BEGIN
    UPDATE DISHES SET DNAME = IN_NEWDNAME, DTYPE = IN_DTYPE, PRICE = IN_PRICE WHERE name = IN_DNAME;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN 
        ROLLBACK;
END;
/

EXECUTE ACTUALIZAR_PLATO('Lentejas con chorizo','Contiene carne', '10.00', 'Lentejas');

------------------------------------------------------------------------------------------------------------------------------------------------------
-----Crear una consulta que muestre un listado agrupado de toda o parte de la  información almacenada.
------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM DISHES WHERE DTYPE = IN_DTYPE GROUP BY ID_RESTAURANT;

------------------------------------------------------------------------------------------------------------------------------------------------------
-----Crear una consulta que muestre, mediante una combinación externa, un listado con toda la información de una tabla principal que no tenga información relacionada en una tabla secundaria.
------------------------------------------------------------------------------------------------------------------------------------------------------
---Antes mostrabamos platos sin restaurante, ahora mostramos restaurantes sin platos---
SELECT RESTAURANTS.ID_RESTAURANT, RESTAURANTS.NAME, RESTAURANTS.NATION, RESTAURANTS.STARS FROM RESTAURANTS LEFT OUTER JOIN DISHES ON RESTAURANTS.ID_RESTAURANT = DISHES.ID_RESTAURANT WHERE DISHES.ID_RESTAURANT IS NULL;



------------------------------------------------------------------------------------------------------------------------------------------------------
-----Crear una consulta que muestre un listado de registros que contengan una determinada cadena en un campo de tu elección.
------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT DNAME, DTYPE, PRICE FROM DISHES WHERE UPPER(DNAME) LIKE UPPER(STR);


------------------------------------------------------------------------------------------------------------------------------------------------------
-----Para finalizar, crea un procedimiento almacenado que realice el borrado de parte de la información almacenada en una tabla secundaria, donde el/los criterios de borrado se obtengan de una tabla principal.
------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_PLATOS (IN_RESTAURANTNAME IN VARCHAR) AS
BEGIN
    DELETE FROM (
    SELECT * FROM DISHES
    LEFT OUTER JOIN RESTAURANTS ON DISHES.ID_RESTAURANT = RESTAURANTS.ID_RESTAURANT
    WHERE UPPER(RESTAURANTS.NAME)=UPPER(IN_RESTAURANTNAME)
    );
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN 
        ROLLBACK;
END;
/

EXECUTE ELIMINAR_PLATOS('La alacena');

