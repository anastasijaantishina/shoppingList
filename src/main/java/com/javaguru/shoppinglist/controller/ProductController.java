package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setDiscount(dto.getDiscount());
        service.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        Product product = service.findById(id);
        return new ProductDTO(product.getId(), product.getName(),
                product.getPrice(), product.getDescription(),
                product.getCategory(), product.getDiscount());
    }


    @GetMapping(params = "name")
    public ProductDTO findProductByName(@RequestParam("name") String name) {
        Product product = service.findByName(name);
        return new ProductDTO(product.getId(), product.getName(),
                product.getPrice(), product.getDescription(),
                product.getCategory(), product.getDiscount());
    }

    @GetMapping("/findAll")
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
