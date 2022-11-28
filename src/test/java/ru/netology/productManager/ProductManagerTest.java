package ru.netology.productManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void RemoveByIdBook() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "book1", 100, "Author1");
        Book book2 = new Book(2, "book2", 200, "Author2");
        Book book3 = new Book(3, "book3", 300, "Author3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TryingToRemoveNotFoundProduct() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "book1", 100, "Author1");
        Book book2 = new Book(2, "book2", 200, "Author2");
        Book book3 = new Book(3, "book3", 300, "Author3");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.removeById(5));
    }
}
