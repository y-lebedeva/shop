package com.epam.javard.shop.dto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "category", schema = "myapp")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;


    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.DETACH})
//    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent=" + (parent != null? parent.name :null)+
                ", children=" + children.stream().map(Category::getName).collect(Collectors.joining(", ")) +
                ", products=" + products.stream().map(Product::getName).collect(Collectors.joining(", ")) +
                '}';
    }
}
