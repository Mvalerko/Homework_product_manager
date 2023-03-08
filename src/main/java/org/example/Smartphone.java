package org.example;

public class Smartphone extends Product {
    private String model;
    private String manufacturer;

    public Smartphone(int idOpt, String nameOpt, int priceOpt, String modelOpt, String manufacturerOpt) {
        super(idOpt, nameOpt, priceOpt);
        this.model = modelOpt;
        this.manufacturer = manufacturerOpt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modelOpt) {
        this.model = modelOpt;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturerOpt) {
        this.manufacturer = manufacturerOpt;
    }

}
