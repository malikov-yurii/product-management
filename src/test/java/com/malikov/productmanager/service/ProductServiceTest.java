package com.malikov.productmanager.service;

import com.malikov.productmanager.ProductTestData;
import com.malikov.productmanager.model.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;

import static com.malikov.productmanager.ProductTestData.*;

public class ProductServiceTest extends AbstractServiceTest {

    @Autowired
    protected ProductService service;

    @Test
    public void add() throws Exception {
        Product newProduct = new Product("newProductName", "newProductProducer", 111, "newProductDescriprion");
        Product created = service.add(newProduct);
        newProduct.setId(created.getId());
        ProductTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(SHELLAC_MANETTI, POTAL_NAZIONALE, FERRARIO_ROZOVYJ, BITUM_DIVOLO, newProduct),
                service.getAll());
    }

    @Test
    public void update() throws Exception {
        Product updated = new Product(POTAL_NAZIONALE);
        updated.setProducer("Nazionale_upd");
        service.update(updated);
        ProductTestData.MATCHER.assertEquals(updated, service.get(POTAL_NAZIONALE.getId()));

    }

    @Test
    public void delete() throws Exception {
        service.delete(POTAL_NAZIONALE.getId());
        ProductTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(SHELLAC_MANETTI, FERRARIO_ROZOVYJ, BITUM_DIVOLO),
                service.getAll());

    }

    @Test
    public void get() throws Exception {
        Product product = service.get(POTAL_NAZIONALE.getId());
        ProductTestData.MATCHER.assertEquals(POTAL_NAZIONALE, product);
    }

    @Test
    public void getAll() throws Exception {
        Collection<Product> all = service.getAll();
        ProductTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(SHELLAC_MANETTI, POTAL_NAZIONALE, FERRARIO_ROZOVYJ, BITUM_DIVOLO),
                all);
    }
}