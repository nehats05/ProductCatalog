package com.catalog.dao;

import com.catalog.Product;

import java.util.List;

public interface ProductDaoInterface {
    void creation(Product product);
    List<Product> getProduct(String category);
    List<Product> getallProducts();
}
