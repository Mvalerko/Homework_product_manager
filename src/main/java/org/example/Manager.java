package org.example;

public class Manager {

ProductRepository repo = new ProductRepository();

    public Manager (ProductRepository repo) {


    }



    public void add (Product managerOption) {
        repo.save(managerOption);
    }
}
