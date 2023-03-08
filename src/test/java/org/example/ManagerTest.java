package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Product galaxy = new Product(
            1,
            "Смартфон",
            65000

    );
    Product onePlus = new Product(
            2,
            "Смартфон",
            54000

    );

    @Test
    public void findAllDefault() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);


        mgr.add(galaxy);
        mgr.add(onePlus);


        Product[] expected = {galaxy, onePlus};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllDefault2() {

        ProductRepository repo = new ProductRepository();
        Manager mgr = new Manager(repo);

        repo.save(galaxy);
        repo.save(onePlus);


        Product[] expected = {galaxy, onePlus};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

}
