package service;

import domain.Book;

import java.util.List;

public interface UserService {
    public List<Book> searchByTitle(String title);
}
