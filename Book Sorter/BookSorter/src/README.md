# Book Sorting Application

This Java program demonstrates the sorting of books using a TreeSet based on different criteria such as book name and page count. The `Book` class implements the `Comparable` interface for natural ordering by book name and uses a `Comparator` for sorting by page count.

## Book Class

The `Book` class represents a book with the following attributes:

- `bookName`: Name of the book
- `pageCount`: Number of pages in the book
- `authorName`: Name of the author
- `publicationDate`: Publication date of the book

## Sorting Books

The program creates instances of the `Book` class with fictional book titles and authors. It then sorts the books based on their names and page counts using a `TreeSet` and a custom `Comparator`.

### Sorting by Book Name

Books are sorted alphabetically by their names.


Set<Book> nameSorting = new TreeSet<>();
// Add books to nameSorting


## Sample Output

### SORT BY BOOK NAME


... java 

Book Name: 1984, Page Count: 328, Author: George Orwell, Publication Date: 1949

Book Name: Brave New World, Page Count: 311, Author: Aldous Huxley, Publication Date: 1932

Book Name: The Catcher in the Rye, Page Count: 280, Author: J.D. Salinger, Publication Date: 1951

Book Name: The Great Gatsby, Page Count: 218, Author: F. Scott Fitzgerald, Publication Date: 1925

Book Name: To Kill a Mockingbird, Page Count: 281, Author: Harper Lee, Publication Date: 1960
SORT BY PAGE COUNT


Book Name: The Great Gatsby, Page Count: 218, Author: F. Scott Fitzgerald, Publication Date: 1925

Book Name: The Catcher in the Rye, Page Count: 280, Author: J.D. Salinger, Publication Date: 1951

Book Name: To Kill a Mockingbird, Page Count: 281, Author: Harper Lee, Publication Date: 1960

Book Name: Brave New World, Page Count: 311, Author: Aldous Huxley, Publication Date: 1932

Book Name: 1984, Page Count: 328, Author: George Orwell, Publication Date: 1949

Feel free to replace the sample book information with your own data.