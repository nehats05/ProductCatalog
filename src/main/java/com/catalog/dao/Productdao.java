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
    public void creation(Product product) {
       productResource.createProduct(product.getName(),product.getDescription(),product.getCategory(),
                                                        product.getTags(),product.getBrand());
       /*return product1;*/
    }

    @Override
    public List<Product> getProduct(String category) {
        return productResource.getProduct(category);
    }

    @Override
    public List<Product> getallProducts() {
        return productResource.getallProducts();
    }

}
