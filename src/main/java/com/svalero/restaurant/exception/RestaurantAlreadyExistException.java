
package com.svalero.restaurant.exception;

public class RestaurantAlreadyExistException extends Exception {

    public RestaurantAlreadyExistException(String message) {
        super(message);
    }

    public RestaurantAlreadyExistException() {
        super("El restaurante ya existe");
    }
}
