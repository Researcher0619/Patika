# Library Management System

This is a simple Library Management System that manages books, authors, categories, publishers, and book borrowing transactions.

## Entities

### Book (Book)

- **id:** Unique identifier for each book.
- **name:** Name of the book.
- **publicationYear:** Year the book was published.
- **stock:** Quantity of the book available in the library.

### Author (Author)

- **id:** Unique identifier for each author.
- **name:** Name of the author.
- **birthDate:** Birth year of the author.
- **country:** Country of the author.

### Category (Category)

- **id:** Unique identifier for each category.
- **name:** Name of the category.
- **description:** Description of the category.

### Publisher (Publisher)

- **id:** Unique identifier for each publisher.
- **name:** Name of the publisher.
- **establishmentYear:** Year the publisher was established.
- **address:** Address of the publisher.

### Book Borrowing (BookBorrowing)

- **id:** Unique identifier for each borrowing transaction.
- **borrowerName:** Name of the person borrowing the book.
- **borrowingDate:** Date when the book is borrowed.
- **returnDate:** Date when the book is returned (initially null, gets updated upon return).

## Relationships

- **Book - Author (One-to-Many):** A book can have one author, but an author can have multiple books.

- **Book - Category (Many-to-Many):** A book can belong to multiple categories, and a category can have multiple books.

- **Book - Publisher (One-to-Many):** A book can have one publisher, but a publisher can have multiple books.

- **Book - Book Borrowing (One-to-Many):** A book can have multiple borrowing transactions, but each borrowing transaction is associated with only one book.


<img width="857" alt="Ekran Resmi 2024-02-13 10 21 33" src="https://github.com/Researcher0619/Patika/assets/102052449/ed7acac0-0af9-498b-8405-2652b6e9590b">


<img width="549" alt="Ekran Resmi 2024-02-13 10 14 46" src="https://github.com/Researcher0619/Patika/assets/102052449/2049eb10-5973-4f6e-8bc4-a5f454e14ffe">


<img width="598" alt="Ekran Resmi 2024-02-13 10 15 33" src="https://github.com/Researcher0619/Patika/assets/102052449/2a171fed-c7e9-4b91-a65d-9d1a6499f88f">


<img width="691" alt="Ekran Resmi 2024-02-13 10 15 57" src="https://github.com/Researcher0619/Patika/assets/102052449/704c913d-f581-4529-bab5-71d2294a7e3d">


<img width="469" alt="Ekran Resmi 2024-02-13 10 16 22" src="https://github.com/Researcher0619/Patika/assets/102052449/66d9eec8-1490-4ace-903d-7b08789347bf">


<img width="308" alt="Ekran Resmi 2024-02-15 17 01 31" src="https://github.com/Researcher0619/Patika/assets/102052449/c680a3a8-db01-4503-b890-74fb1d9e4c59">







<img width="602" alt="Ekran Resmi 2024-02-13 10 17 02" src="https://github.com/Researcher0619/Patika/assets/102052449/ef7c42e7-a9b5-4b2f-86c5-77760bfb85a7">




