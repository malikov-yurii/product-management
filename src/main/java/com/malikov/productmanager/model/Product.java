package com.malikov.productmanager.model;

import javax.persistence.*;

//@NamedQueries({
//        @NamedQuery(name = Product.DELETE, query = "DELETE FROM Product p WHERE p.id=:id"),
//        @NamedQuery(name = Product.BY_CATEGORY_ID, query =
//                "SELECT p FROM Product p JOIN p.categories c WHERE c.id=:categoryId"),
//        @NamedQuery(name = Product.QUANTITY_LESS_THAN, query =
//                "SELECT p FROM Product p WHERE p.quantity < :quantity"),
//        @NamedQuery(name = Product.ALL_SORTED, query = "SELECT p FROM Product p ORDER BY p.price"),
//})
@Entity
@Table(name = "products")
public class Product{


//    public static final String DELETE = "Product.delete";
//    public static final String BY_CATEGORY_ID = "Product.getByCategoryId";
//    public static final String QUANTITY_LESS_THAN = "Product.getQuantityLessThan";
//    public static final String ALL_SORTED = "Product.getAllSorted";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "producer")
    private String producer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
