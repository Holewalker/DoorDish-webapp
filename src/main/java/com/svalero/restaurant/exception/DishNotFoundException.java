package com.svalero.restaurant.exception;

public class DishNotFoundException extends Exception {

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException() {
        super("El plato no existe");
    }
}
