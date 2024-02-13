package com.bookborrowing;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")

public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;



    @Column(name = "category_name",length = 200, nullable = false)
    private String category_name;


    @Column(name = "description",length = 1000, nullable = false)
    private String description;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "category2book",
            joinColumns = {@JoinColumn(name = "category2book_id")},
    inverseJoinColumns = {@JoinColumn(name = "book2category_id")})

    private List<Book> bookList;

    public Category() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                ", description='" + description + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}