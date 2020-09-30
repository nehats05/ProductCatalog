package com.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private String description;
    private String brand;
    private String[] tags;
    private String category;
    @Column(name = "createdat")
    private Timestamp createdat;

    public Product()
    { }

    public Product(int id, String name, String description, String brand, String[] tags, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.tags = tags;
        this.category = category;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Timestamp createdat) {
        this.createdat = createdat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
