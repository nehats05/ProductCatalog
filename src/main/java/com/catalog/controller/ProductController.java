package com.catalog.controller;

import com.catalog.Product;
import com.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //insertion of new product to repo
    @RequestMapping(value = "/productcreation",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product)
    {
         productService.productcreation(product);
    }

    @RequestMapping(value = "/getProducts",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getallProducts()
    {
        return productService.getallProducts();
    }

    //serach the product based on the category and get the list of products matching the category
    @RequestMapping(value = "/v1/products",method = RequestMethod.GET)
    public List<Product> getProductDetails(@RequestParam("category") String category)
    {
        return productService.getProduct(category);
    }



}
