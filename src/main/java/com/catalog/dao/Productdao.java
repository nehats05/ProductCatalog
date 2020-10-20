package com.catalog.dao;

import com.catalog.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class Productdao implements ProductDaoInterface {

    @Autowired
    private ProductResource productResource;

    @Override
    public void creation(Product product) {
       productResource.createProduct(product.getId(),product.getName(),product.getDescription(),product.getCategory(),
                                                        product.getTags(),product.getCreatedat(),product.getBrand());

    }

    @Override
    public List<Product> getProduct(String category) {
        List<Product> products= productResource.getProduct(category);
        products.sort(Comparator.comparing(Product::getCreatedat));    //sorting the list based on createdat localdatetime
        return products;
    }

    @Override
    public List<Product> getallProducts() {
        return productResource.getallProducts();
    }

}
