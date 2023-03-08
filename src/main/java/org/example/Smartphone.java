package org.example;

public class Smartphone extends Product {
        private String model;
        private String manufacturer;

        public Smartphone(int idOpt, String nameOpt, int priceOpt, String modelOpt, String manufacturerOpt) {
            super(idOpt, nameOpt, priceOpt);
            this.model = modelOpt;
            this.manufacturer = manufacturerOpt;
        }

        @Override
        public void use() {
            System.out.println("Читаем книгу: " + name);
        }

        @Override
        public boolean isTooExpensive() {
            if (price > 10_000) {
                return true;
            } else {
                return false;
            }
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
