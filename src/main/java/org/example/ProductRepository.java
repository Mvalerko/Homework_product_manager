package org.example;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {

        if (findById(item.id) != null) {
            throw new AlreadyExistsException("При попытке добавить продукт в массив вы указали продукт с уже существующим в массиве id(" + item.id + ")" +
                    " Операция не выполнена. В массиве остался только один продукт с id(" + item.id + ")");
        } else {
            Product[] tmp = new Product[items.length + 1];
            for (int i = 0; i < items.length; i++) {
                tmp[i] = items[i];
            }
            tmp[tmp.length - 1] = item;
            items = tmp;
        }
    }

    public void removeById(int idOpt) {

        if (findById(idOpt) == null) {
            throw new NotFoundException("При попытке удаления ячейки из массива Вы ввели несуществующий id(" +idOpt+  ") продукта." +
                    " Операция не выполнена.");
        } else {

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

    public Product findById(int idOpt) {

        for (Product product : items) {
            if (matches(product, idOpt)) {
                return product;
            }
        }
        return null;
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
