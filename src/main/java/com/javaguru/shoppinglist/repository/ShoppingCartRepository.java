package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class ShoppingCartRepository {

    private final SessionFactory sessionFactory;


    @Autowired
    public ShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ShoppingCart save(ShoppingCart cart) {
        sessionFactory.getCurrentSession().save(cart);
        return cart;
    }

    public void update(ShoppingCart cart) {
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
    }

    public Optional<ShoppingCart> findCartByName(String name){
        ShoppingCart cart = (ShoppingCart) sessionFactory.getCurrentSession()
                .createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(cart);

    }

    public List<ShoppingCart> findAll() {
        return sessionFactory.getCurrentSession()
                .createCriteria(ShoppingCart.class).list();
    }

    public void deleteById(Long id){
        ShoppingCart cart = (ShoppingCart) sessionFactory.getCurrentSession().load(ShoppingCart.class, id);
        sessionFactory.getCurrentSession().delete(cart);
    }

    public boolean existByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from ShoppingCart s where s.name='" + name + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }

    public void saveProductToList(Product product, ShoppingCart cart){
        cart.getProducts().add(product);
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
    }

}
