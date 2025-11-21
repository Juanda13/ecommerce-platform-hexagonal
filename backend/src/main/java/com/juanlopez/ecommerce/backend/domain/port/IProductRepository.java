package com.juanlopez.ecommerce.backend.domain.port;

import com.juanlopez.ecommerce.backend.domain.model.Product;

public interface IProductRepository {

    Product save(Product product);
    Iterable<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);

}
