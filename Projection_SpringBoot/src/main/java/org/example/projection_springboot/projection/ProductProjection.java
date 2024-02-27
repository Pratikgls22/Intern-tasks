package org.example.projection_springboot.projection;

public interface ProductProjection {
    // create only get method which we want;

    Integer getId();
    String getName();
    Double getPrice();
    Integer getQuanlity();
}
