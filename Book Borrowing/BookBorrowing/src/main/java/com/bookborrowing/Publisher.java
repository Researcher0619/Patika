package com.bookborrowing;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;


    @Column(name = "publisher_name",length = 200, nullable = false)
    private String publisher_name;

    @Column(name = "establishment_year")
    private int establishment_year;


    @Column(name = "publisher_address",length = 200, nullable = false)
    private String publisher_address;


    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> bookList ;
    public Publisher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public int getEstablishment_year() {
        return establishment_year;
    }

    public void setEstablishment_year(int establishment_year) {
        this.establishment_year = establishment_year;
    }

    public String getPublisher_address() {
        return publisher_address;
    }

    public void setPublisher_address(String publisher_address) {
        this.publisher_address = publisher_address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}