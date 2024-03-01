package org.example.projection_springboot.repository;

import org.example.projection_springboot.entity.Product;
import org.example.projection_springboot.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "select id,name,price,quanlity from product_table",nativeQuery = true)
    List<ProductProjection> getProductsWithRequeriedAttributes();
}
