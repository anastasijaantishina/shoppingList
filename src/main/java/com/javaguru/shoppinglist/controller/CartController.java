package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final ShoppingCartService service;

    public CartController(ShoppingCartService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<ShoppingCart> create(@RequestBody CartDTO dto) {
        ShoppingCart cart = new ShoppingCart();
        cart.setName(dto.getName());
        service.createCart(cart);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/getAll")
    public List<CartDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable("id") Long id){
        service.deleteById(id);
    }



}
