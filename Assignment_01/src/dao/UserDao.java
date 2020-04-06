package dao;

import domain.Book;

import java.util.List;

public interface UserDao {
    public List<Book> searchByTitle(String title);
}
