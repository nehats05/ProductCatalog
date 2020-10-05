package com.catalog.service;

import com.catalog.Product;
import java.util.List;

public interface ProductService {
    void productcreation(Product product);
    List<Product> getProduct(String category);
    List<Product> getallProducts();
}
