package br.imd.ufrn.webII.msstockLB.service;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import br.imd.ufrn.webII.msstockLB.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllGreetings() {
        return productRepository.findAll();
    }

    public String saveProductDatabase(Product product){
        productRepository.save(product);
        return "Product stored with id " + product.getId();
    }
}
