package com.catalog.dao;

import com.catalog.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductResource extends CrudRepository {
        @Modifying
        @Query(value = "insert into products values(:name,:description,:brand,:tags,:category)",nativeQuery = true)
        Product createProduct(@Param("name") String name,@Param("description") String description,@Param("brand") String brand,
                              @Param("tags") String[] tags, @Param("category") String category);

        @Query(value = "select id,name,category,createdat from products where category = :category",nativeQuery = true)
        Product[] getProduct(@Param("category") String category);
}
