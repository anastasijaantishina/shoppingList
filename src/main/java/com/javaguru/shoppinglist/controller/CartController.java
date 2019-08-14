package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deleteById(id);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable("id") Long id, @RequestBody CartDTO dto){
//        service.update(dto);
//    }

    @GetMapping(params = "name")
    public CartDTO findCartByName(@RequestParam("name") String name) {
        ShoppingCart cart = service.findCartByName(name);
        return new CartDTO(cart.getId(), cart.getName(), cart.getProductCount(), cart.getTotalAmount());
    }

    @PutMapping("/{id}carts{cartId}")
    public void update(@PathVariable("id") Long id, @PathVariable("cartId") Long cartId,
                       @RequestBody ProductDTO dto, @RequestBody CartDTO dtocart) {
        service.saveProductToList(dto, dtocart);
    }




}
