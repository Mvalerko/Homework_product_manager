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
            "Смартфон544645564!@ё]",
            54000,
            "11",
            "OnePlus"

    );
    Product pixel = new Smartphone(
            4,
            "Smartphone",
            55000,
            "7 Pro",
            "Google"

    );
    Product book1963 = new Book(
            3,
            "Книга",
            630,
            "Стивен Кинг",
            "11/22/63"
    );
    Product bookMetro = new Book(
            7,
            "!№{",
            680,
            "Дмитрий Глуховский",
            "Метро 2034"
    );

    @Test
    public void findAllDefault() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);

        Product[] expected = {galaxy, onePlus, book1963};
        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findAllZero() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);


        Product[] expected = {};
        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesСyrillicTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);

        Product[] expected = {book1963};

        Product[] actual = mgr.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesSymbolTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.add(bookMetro);

        Product[] expected = {bookMetro};

        Product[] actual = mgr.searchBy("№{");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesСyrillicTestMore() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);

        Product[] expected = {galaxy, onePlus};

        Product[] actual = mgr.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesСyrillicTestYo() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);

        Product[] expected = {onePlus};

        Product[] actual = mgr.searchBy("ё");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.add(pixel);

        Product[] expected = {pixel};

        Product[] actual = mgr.searchBy("Smartphone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notMatchesTest() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

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
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.removeById(2);


        Product[] expected = {galaxy, book1963};

        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeInvalidIndex() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.removeById(9);

        Product[] expected = {galaxy, onePlus, book1963};

        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeInvalidIndexZero() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.removeById(0);

        Product[] expected = {galaxy, onePlus, book1963};

        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeInvalidIndexNegative() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        mgr.add(galaxy);
        mgr.add(onePlus);
        mgr.add(book1963);
        mgr.removeById(-5);

        Product[] expected = {galaxy, onePlus, book1963};

        Product[] actual = mgr.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
