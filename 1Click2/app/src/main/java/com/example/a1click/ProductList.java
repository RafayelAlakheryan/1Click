package com.example.a1click;
import java.util.ArrayList;
import java.util.List;



public class ProductList {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }


}


