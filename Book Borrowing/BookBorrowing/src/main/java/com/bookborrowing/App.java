package com.bookborrowing;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        // Author Adding
        Author author = new Author();
        author.setAuthor_name("George Orwell");
        author.setAuthor_birthday(LocalDate.of(1903, 6, 25));
        author.setAuthor_country("United Kingdom");
        entityManager.persist(author);

        // Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setPublisher_name("Penguin Books");
        publisher.setPublisher_address("London");
        publisher.setEstablishment_year(1935);
        entityManager.persist(publisher);

        // Category Adding
        Category categoryFiction = new Category();
        categoryFiction.setCategory_name("Fiction");
        categoryFiction.setDescription("Novels and stories");
        entityManager.persist(categoryFiction);

        // Book Adding
        Book book = new Book();
        book.setBook_name("1984");
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setStock(25);
        book.setPublication_year(1949);
        entityManager.persist(book);

        // BookBorrowing Adding
        Borrowing borrowing = new Borrowing();
        borrowing.setBorrower_name("John Doe");
        borrowing.setBorrowing_date(LocalDate.of(2024, 2, 5));
        borrowing.setReturn_date(LocalDate.of(2024, 2, 15));
        borrowing.setBook(book);
        entityManager.persist(borrowing);


        entityTransaction.commit();
    }
}
