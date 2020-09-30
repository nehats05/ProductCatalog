package com.catalog.service;

import com.catalog.Product;

public interface ProductService {
    Product productcreation(Product product);
    Product[] getProduct(String category);
}
