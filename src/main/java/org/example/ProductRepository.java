package org.example;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int idOpt) {

        for (Product product : items) {
            if (matches(product, idOpt)) {
                Product[] tmp = new Product[items.length - 1];
                int copyToIndex = 0;
                for (Product item : items) {
                    if (item.getId() != idOpt) {
                        tmp[copyToIndex] = item;
                        copyToIndex++;

                    }
                }
                items = tmp;
            }
        }
    }

    public boolean matches(Product product, int search) {
        if (product.getId() == search) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Product[] getItems() {
        return items;
    }
}
