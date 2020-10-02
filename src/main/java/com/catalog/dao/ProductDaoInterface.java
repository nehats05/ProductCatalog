package com.catalog.dao;

import com.catalog.Product;

import java.util.List;

public interface ProductDaoInterface {
    Product creation(Product product);
    List<Product> getProduct(String category);
}
