package br.imd.ufrn.webII.msstockLB.controller;

import br.imd.ufrn.webII.msstockLB.entity.Product;
import br.imd.ufrn.webII.msstockLB.service.ProductService;
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
    @GetMapping("/findAll")
    public List<Product> getAllProducts(){
        return productService.findAllProducts();
    }
    @ResponseBody
    @GetMapping
    public Product getProductByID(@RequestParam Long productId){
        return productService.findProductById(productId);
    }



    @ResponseBody
    @PutMapping("/update/{productId}")
    public String putProduct(@PathVariable Long productId, @RequestBody Product updateProduct){
        return productService.updateProduct(productId, updateProduct);
    }


    @ResponseBody
    @ResponseStatus
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }

    @ResponseBody
    @GetMapping("/findName")
    public List<Product> getProductsByName(@RequestParam String name){
        return productService.findProductsByName(name);
    }



    @ResponseBody
    @ResponseStatus
    @PostMapping
    public String saveProduct(@RequestBody Product product){
        return productService.saveProductDatabase(product);
    }
}
