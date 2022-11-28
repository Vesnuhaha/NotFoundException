package ru.netology.productManager;

public class Repository {

    Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public Product[] findAll() {

        return products;
    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int removeId) {

        if (findById(removeId) == null) {
            throw new NotFoundException(removeId);
        }
        Product[] tmp = new Product[products.length - 1];
        int indexTo = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[indexTo] = product;
                indexTo++;
            }
        }
        products = tmp;
    }

}

