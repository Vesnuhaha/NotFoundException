package ru.netology.productManager;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Element with id: " + id + " not found");
    }
}
