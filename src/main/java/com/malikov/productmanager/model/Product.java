package com.malikov.productmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends NamedEntity{

    @Column(name = "producer")
    private String producer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    public Product() {
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
