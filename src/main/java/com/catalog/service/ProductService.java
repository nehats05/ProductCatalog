package com.catalog.service;

import com.catalog.Product;
import java.util.List;

public interface ProductService {
    Product productcreation(Product product);
    List<Product> getProduct(String category);
}
