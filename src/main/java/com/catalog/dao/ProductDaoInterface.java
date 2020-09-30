package com.catalog.dao;

import com.catalog.Product;

public interface ProductDaoInterface {
    Product creation(Product product);
    Product[] getProduct(String category);
}
