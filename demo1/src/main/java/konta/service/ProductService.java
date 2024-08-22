package konta.service;

import konta.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Integer id);
    Boolean save(Product product);
    Boolean delete(Integer id);
}
