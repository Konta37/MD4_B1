package konta.service;

import konta.model.entity.Product;
import konta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean save(Product product) {
        try {
            this.productRepository.save(product);
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        productRepository.deleteById(id);
        return true;
    }
}
