package com.bookborrowing;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "author_name",length = 200, nullable = false)
    private String author_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_day")
    private LocalDate author_birthday;


    @Column(name = "author_country", length = 200, nullable = false)
    private String author_country;


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> bookList ;



    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public LocalDate getAuthor_birthday() {
        return author_birthday;
    }

    public void setAuthor_birthday(LocalDate author_birthday) {
        this.author_birthday = author_birthday;
    }

    public String getAuthor_country() {
        return author_country;
    }

    public void setAuthor_country(String author_country) {
        this.author_country = author_country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}