package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements Repository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public boolean existByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from Task t where t.name='" + name + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }

    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    public Product changeProductName(Long id, String name){
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        product.setName(name);
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    public Product changeProductPrice(Long id, BigDecimal price){
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        product.setPrice(price);
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    public Product changeProductDiscount(Long id, BigDecimal discount){
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        product.setDiscount(discount);
        sessionFactory.getCurrentSession().update(product);
        return product;
    }

    public Product changeProductDescription(Long id, String description){
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, id);
        product.setDescription(description);
        sessionFactory.getCurrentSession().update(product);
        return product;
    }
}
