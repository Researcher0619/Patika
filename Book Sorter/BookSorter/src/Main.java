import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Catcher in the Rye", 280, "J.D. Salinger", "1951");
        Book book2 = new Book("1984", 328, "George Orwell", "1949");
        Book book3 = new Book("The Great Gatsby", 218, "F. Scott Fitzgerald", "1925");
        Book book4 = new Book("To Kill a Mockingbird", 281, "Harper Lee", "1960");
        Book book5 = new Book("Brave New World", 311, "Aldous Huxley", "1932");

        // Set that sorts books by name
        Set<Book> nameSorting = new TreeSet<>();
        nameSorting.add(book1);
        nameSorting.add(book2);
        nameSorting.add(book3);
        nameSorting.add(book4);
        nameSorting.add(book5);

        System.out.println("**SORT BY BOOK NAME**");
        for (Book book : nameSorting) {
            System.out.println(book);
        }

        // Comparator to sort books by page count
        Comparator<Book> pageCountComparator = Comparator.comparingInt(Book::getPageCount);

        // Set that sorts books by page count
        Set<Book> pageCountSorting = new TreeSet<>(pageCountComparator);
        pageCountSorting.addAll(nameSorting);

        System.out.println("\n**SORT BY PAGE COUNT**");
        for (Book book : pageCountSorting) {
            System.out.println(book);
        }
    }
}
