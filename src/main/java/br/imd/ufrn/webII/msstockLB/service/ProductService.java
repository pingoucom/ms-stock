package br.imd.ufrn.webII.msstockLB.service;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import br.imd.ufrn.webII.msstockLB.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    public String updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrecoUnitario(updatedProduct.getPrecoUnitario());
            existingProduct.setDataEntrada(updatedProduct.getDataEntrada());
            existingProduct.setDataSaida(updatedProduct.getDataSaida());
            productRepository.save(existingProduct);
            return "Product updated successfully";
        } else {
            return "Product with ID " + productId + " not found";
        }
    }


    public String deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            productRepository.deleteById(productId);
            return "Product with ID " + productId + " deleted successfully";
        } else {
            return "Product with ID " + productId + " not found";
        }
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name);
    }





    public String saveProductDatabase(Product product){
        productRepository.save(product);
        return "Product stored with id " + product.getId();
    }
}
