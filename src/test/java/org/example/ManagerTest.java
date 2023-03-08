package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Product galaxy = new Smartphone(
            1,
            "Смартфон",
            65000,
            "Galaxy S23",
            "Samsung"

    );
    Product onePlus = new Smartphone(
            2,
            "Смартфон",
            54000,
            "1",
            "OnePlus"

    );
    Product book1963 = new Book(
            3,
            "Книга",
            630,
            "Стивен Кинг",
            "11/22/63"
    );

    @Test
    public void findAllDefault() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager();


        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);


        Product[] expected = {galaxy, onePlus, book1963};
        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager();


        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);



        Product[] expected = {book1963};

        Product[] actual = mgr.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notMatchesTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager();


        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);



        Product[] expected = {};

        Product[] actual = mgr.searchBy("Телевизор");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void remove() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager();


        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.removeById(2);

        Product[] expected = {galaxy, book1963};

        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
