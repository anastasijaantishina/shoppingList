package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.CartDTO;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.CartConverter;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.service.cartValidation.CartValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository repository;
    private final CartConverter converter;
    private final ProductConverter productconverter;
    private final CartValidationService service;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository repository, CartConverter converter, ProductConverter productconverter, CartValidationService service) {
        this.repository = repository;
        this.converter = converter;
        this.productconverter = productconverter;
        this.service = service;
    }

    public CartDTO saveProductToList(ProductDTO productdto, CartDTO cartdto){
        ShoppingCart cart = converter.convert(cartdto);
        Product product = productconverter.convert(productdto);
        repository.saveProductToList(product, cart);
        return cartdto;
    }

    public Long createCart(CartDTO cartdto) {
        service.validate(cartdto);
        ShoppingCart cart = converter.convert(cartdto);
        ShoppingCart createdCart = repository.save(cart);
        return createdCart.getId();
    }

    public void update(CartDTO dto) {
        ShoppingCart cart = converter.convert(dto);
        repository.update(cart);
    }

    public CartDTO findCartByName(String name) {
        return repository.findCartByName(name)
                .map(shoppingCart -> converter.convert(shoppingCart))
                .orElseThrow(() -> new IllegalArgumentException("Cart not found by name" + name));
    }

    public List<CartDTO> findAll() {
        return repository.findAll().stream()
                .map(shoppingCart -> converter.convert(shoppingCart))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
