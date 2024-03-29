package br.imd.ufrn.webII.msstockLB.service;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import br.imd.ufrn.webII.msstockLB.repository.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public String saveProductDatabase(Product product){
        productRepository.save(product);
        return "Product stored with id " + product.getId();
    }
}
