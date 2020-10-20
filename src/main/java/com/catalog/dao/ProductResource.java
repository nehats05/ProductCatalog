package com.catalog.dao;

import com.catalog.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductResource extends CrudRepository<Product,Product> {
        //while inserting data into the repo need to use Modifying annotation
        //With this annotation only void or int value can be returned
        @Modifying
        @Query(value = "insert into products(id,name,description,category,tags,createdat,brand) values(:id,:name,:description,:category,:tags,:createdat,:brand)",nativeQuery = true)
        void createProduct(@Param("id") int id, @Param("name") String name, @Param("description") String description,
                           @Param("category") String category, @Param("tags") String tags,
                           @Param("createdat") LocalDateTime createdat, @Param("brand") String brand);

        @Query(value = "select id,name,description,brand,tags,category,createdat from products where category = :category",nativeQuery = true)
        List<Product> getProduct(@Param("category") String category);

        @Query(value = "select * from products",nativeQuery = true)
        List<Product> getallProducts();
}
