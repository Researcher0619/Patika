package com.bookborrowing;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookborrowing")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private int id;

    @Column(name = "borrower_name",length = 200, nullable = false)
    private String borrower_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date",nullable = false)
    private LocalDate borrowing_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate return_date;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Borrowing() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }

    public LocalDate getBorrowing_date() {
        return borrowing_date;
    }

    public void setBorrowing_date(LocalDate borrowing_date) {
        this.borrowing_date = borrowing_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", borrower_name='" + borrower_name + '\'' +
                ", borrowing_date=" + borrowing_date +
                ", return_date=" + return_date +
                ", book=" + book +
                '}';
    }
}