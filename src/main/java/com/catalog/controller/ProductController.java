package com.catalog.controller;

import com.catalog.Product;
import com.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/productcreation",method= RequestMethod.POST)
    public Product createProduct(@RequestBody Product product)
    {
        return productService.productcreation(product);
    }

    @RequestMapping(value = "/v1/products",method = RequestMethod.GET)
    public Product[] getProductDetails(@RequestParam("category") String category)
    {
        return productService.getProduct(category);
    }



}
