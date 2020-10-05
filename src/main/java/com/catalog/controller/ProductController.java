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

    @RequestMapping(value = "/productcreation",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product)
    {
        /*Product product1 = new Product();
        product1.setName("Red Shirt");
        product1.setDescription("Red hugo boss shirt");
        product1.setBrand("Hugo Boss");
        product1.setTags(new String[]{"red", "shirt", "slim fit"});
        product1.setCategory("Apparel");*/
         productService.productcreation(product);
    }

    @RequestMapping(value = "/getProducts",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getallProducts()
    {
        return productService.getallProducts();
    }

    @RequestMapping(value = "/v1/products",method = RequestMethod.GET)
    public List<Product> getProductDetails(@RequestParam("category") String category)
    {
        return productService.getProduct(category);
    }



}
