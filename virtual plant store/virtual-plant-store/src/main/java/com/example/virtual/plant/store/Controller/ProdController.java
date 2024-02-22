package com.example.virtual.plant.store.Controller;

import com.example.virtual.plant.store.entity.Products;
import com.example.virtual.plant.store.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/Products")
public class ProdController {

    @Autowired
    public ProductsRepo productsRepo;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Products obj){
        obj.setAvailability("in stock");
        productsRepo.save(obj);
        return new ResponseEntity<>("product added", HttpStatus.OK);
    }

    @GetMapping("/getProds")
    public ResponseEntity<?> getProducts(){
        var prods = productsRepo.findAll();
        return new ResponseEntity<>(prods,HttpStatus.OK);
    }

    @PutMapping("/updateProds/{pid}")
    public ResponseEntity<?> updateProds(@RequestBody Products obj,@PathVariable Integer id){
        Products prods =  productsRepo.findById(id).orElseThrow(()->new RuntimeException("prod not found"));
        prods.setName(obj.getName());
        prods.setPrice(obj.getPrice());
        prods.setAvailability(obj.getAvailability());
        prods.setDescription(obj.getDescription());
        prods.setCategory(obj.getCategory());
        if(!obj.getImage().isEmpty()){
            prods.setImage(obj.getImage());
        }
        productsRepo.save(prods);
        return new ResponseEntity<>("prods updated",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<?> delete(@PathVariable Integer pid){
        Products prods = productsRepo.findById(pid).orElseThrow(()->new RuntimeException("product not found"));
        productsRepo.delete(prods);
        return new ResponseEntity<>("prods deleted",HttpStatus.OK);
    }
}
