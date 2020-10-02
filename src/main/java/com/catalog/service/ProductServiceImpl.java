package com.catalog.service;

import com.catalog.Product;
import com.catalog.dao.ProductDaoInterface;
import com.catalog.dao.Productdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDaoInterface productdao;

    @Override
    public Product productcreation(Product product) {
       return productdao.creation(product);
    }

    @Override
    public List<Product> getProduct(String category) {
        return productdao.getProduct(category);
    }
}
