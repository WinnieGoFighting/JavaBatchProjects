package service.impl;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Book;
import service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<Book> searchByTitle(String title) {
        return dao.searchByTitle(title);
    }
}
