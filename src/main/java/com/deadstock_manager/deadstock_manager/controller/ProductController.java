package com.deadstock_manager.deadstock_manager.controller;

import com.deadstock_manager.deadstock_manager.entity.Product;
import com.deadstock_manager.deadstock_manager.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllData(){
        List<Product> products = productService.findAll();
        if(products!=null){
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        Product res = productService.addProduct(product);
        System.out.println("desc: "+res.description);
        if(product!=null){
            return new ResponseEntity<>("Product Added",HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Not Added",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/search/{keyword}/categories/{option}")
    public ResponseEntity<List<Product>> searchProduct(@PathVariable String keyword, @PathVariable("option") String option){

        List<Product> products = switch (option) {
            case "dsrNo" -> productService.searchProductByDsrNo(keyword);
            case "type" -> productService.searchProductByType(keyword);
            case "roomNo" -> productService.searchProductByRoomNo(keyword);
            case "category" -> productService.searchProductByCategory(keyword);
            default -> null;
        };

        if(products != null && !products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProduct(@RequestBody List<Product> products){
        if(productService.deleteProduct(products)) {
            return new ResponseEntity<>("Record(s) deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
    }
    @PutMapping("/update-product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(updatedProduct);

        if(product!=null)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
