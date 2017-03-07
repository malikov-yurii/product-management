package com.malikov.productmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends NamedEntity {

    @Column(name = "producer")
    private String producer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Product(Integer id, String name, String producer, Integer price, String description) {
        super(id, name);
        this.producer = producer;
        this.price = price;
        this.description = description;
    }

    public Product(Product product) {
        this(product.getId(), product.getName(), product.getProducer(), product.getPrice(), product.getDescription());
    }

    public Product(String name, String producer, Integer price, String description) {
        this(null, name, producer, price, description);
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
