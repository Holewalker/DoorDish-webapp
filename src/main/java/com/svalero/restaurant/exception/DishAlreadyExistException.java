package com.svalero.restaurant.exception;

public class DishAlreadyExistException extends Exception {

    public DishAlreadyExistException(String message) {
        super(message);
    }

    public DishAlreadyExistException() {
        super("El plato ya existe");
    }
}
