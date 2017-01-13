package com.malikov.productmanager.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class NamedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(value = AccessType.PROPERTY)
    protected Integer id;


    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    public boolean isNew() {
        return (getId() == null);
    }

    protected NamedEntity(Integer id, String name) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                " name='" + name + '\'';
    }
}
