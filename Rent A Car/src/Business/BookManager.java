package Business;

import Core.Helper;
import Dao.BookDao;
import Entity.Book;

import java.util.ArrayList;

public class BookManager {

    private BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public boolean save(Book book) {
        return this.bookDao.save(book);
    }

    public boolean delete(int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID Kayıtlı araç bulunamadı.");
            return false;
        }
        return this.bookDao.delete(id);
    }

    public Book getById(int id) {
        return this.bookDao.getById(id);
    }

    public ArrayList<Book> findAll() {
        return this.bookDao.findAll();
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> books) {
        ArrayList<Object[]> bookList = new ArrayList<>();
        for (Book obj : books) {
            int i = 0;
            Object[] rowObject = new Object[size];
            // Populate the rowObject with book information
            rowObject[i++] = obj.getId();
            // Add other properties of the Book class here
            // For example: rowObject[i++] = obj.getSomeProperty();
            bookList.add(rowObject);
        }
        return bookList;
    }

    public ArrayList<Book> searchForTable(int carId) {
        String select = "SELECT * FROM public.book";
        ArrayList<String> whereList = new ArrayList<>();

        if (carId != 0) {
            whereList.add("book_car_id = " + carId);
        }

        String whereStr = String.join(" AND ", whereList);
        String query = select;
        if (!whereStr.isEmpty()) {
            query += " WHERE " + whereStr;
        }

        return this.bookDao.selectByQuery(query);
    }
}
