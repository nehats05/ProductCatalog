package com.catalog.dao;

import com.catalog.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Productdao implements ProductDaoInterface {

    @Autowired
    private ProductResource productResource;

    @Override
    public Product creation(Product product) {
        Product product1= productResource.createProduct(product.getName(),product.getDescription(),product.getBrand(),
                                                        product.getTags(),product.getCategory());
       return product1;
    }

    @Override
    public List<Product> getProduct(String category) {
        return productResource.getProduct(category);
    }

}
