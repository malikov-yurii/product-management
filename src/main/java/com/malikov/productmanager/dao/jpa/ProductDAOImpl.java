package com.malikov.productmanager.dao.jpa;

import com.malikov.productmanager.dao.ProductDAO;
import com.malikov.productmanager.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ProductDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Product product) {
        em.persist(product);
        LOG.info("Product successfully saved. Product details: " + product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
        LOG.info("Product successfully updated. Product details: " + product);
    }

    @Override
    public void delete(int id) {
        Product product = get(id);
        if (product != null) {
            em.remove(product);
            LOG.info("Product successfully deleted.");
        }
        LOG.error("Product not found. Product was not deleted.");
    }

    @Override
    public Product get(int id) {
        Product product = em.find(Product.class, id);
        if (product != null)
            LOG.info("Product was successfully retrieved from DB.");
        else
            LOG.error("Product not found.");
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        List<Product> products = (List<Product>) em.createQuery("FROM Product").getResultList();
        if (products.size() != 0){
            LOG.info("Products: ");
            products.forEach(p -> LOG.info(p.toString()));
        }
        return products;
    }
}
