package br.imd.ufrn.webII.msstockLB.controller;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import br.imd.ufrn.webII.msstockLB.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public final class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @ResponseBody
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.findAllGreetings();
    }

    @ResponseBody
    @ResponseStatus
    @PostMapping
    public String saveProduct(@RequestBody Product product){
        return productService.saveProductDatabase(product);
    }
}
