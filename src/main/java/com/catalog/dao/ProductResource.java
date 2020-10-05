package com.catalog.dao;

import com.catalog.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductResource extends CrudRepository<Product,Product> {
        @Modifying
        @Query(value = "insert into products(name,description,category,tags,brand) values(:name,:description,:category,:tags,:brand)",nativeQuery = true)
        void createProduct(@Param("name") String name,@Param("description") String description,
                           @Param("category") String category, @Param("tags") String tags,@Param("brand") String brand);

        @Query(value = "select id,name,category,createdat from products where category = :category",nativeQuery = true)
        List<Product> getProduct(@Param("category") String category);

        @Query(value = "select * from products",nativeQuery = true)
        List<Product> getallProducts();
}
