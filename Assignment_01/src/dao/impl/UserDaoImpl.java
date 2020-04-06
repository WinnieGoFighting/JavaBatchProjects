package dao.impl;

import dao.UserDao;
import domain.Book;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static java.sql.DriverManager.*;

public class UserDaoImpl implements UserDao {

    @Override
    @Test
    public List<Book> searchByTitle(String title) {
        //method 3: use Spring JDBCTemplate to connect to database
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String t = '\"'+title+"\"";
        String sql = "select * from books where title = "+t;
        List<Book> bookList = template.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    public static void main (String[] args) {
        //method 1 : use plain connection
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = getConnection("jdbc:mysql:///bookstore","root","12345");
//            String sql = "update books set id = 1 where id = 3";
//            Statement stmt = conn.createStatement();
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count);
//            stmt.close();
//            conn.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //2 try use JDBCUtils with Druid
//        try {
//            Connection conn = JDBCUtils.getConnection();
//            String sql = "update books set id = 2 where id = 4";
//            Statement stmt = conn.createStatement();
//            int count = stmt.executeUpdate(sql);
//            System.out.println(count);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
