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

