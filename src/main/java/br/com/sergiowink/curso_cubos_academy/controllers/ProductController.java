package br.com.sergiowink.curso_cubos_academy.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergiowink.curso_cubos_academy.exceptions.ProductNotFound;
import br.com.sergiowink.curso_cubos_academy.models.Product;
import br.com.sergiowink.curso_cubos_academy.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public List<Product> list() {
        return productRepository.findAll();

    }

    @GetMapping(value = "/{id}")
    public Product geProduct(@PathVariable Long id){
        Product product = this.productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFound();
        });

        return product;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Product product){
        Product newProduct = productRepository.save(product);
        return new ResponseEntity<Object>(newProduct, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        Product product = this.productRepository.findById(id).orElseThrow(() -> {
            throw new ProductNotFound();
        });
        productRepository.delete(product);
    }
}
