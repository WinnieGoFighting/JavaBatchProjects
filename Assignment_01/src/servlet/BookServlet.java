package servlet;

import domain.Book;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.crypto.CipherOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. get parameter
        String title = request.getParameter("title");

        //1. call UserService's method searchByTitle
        UserService service = new UserServiceImpl();
        List<Book> bookList = service.searchByTitle(title);

        if (bookList.size()==0) {
            String errorMsg = title+" is not found.";
            request.setAttribute("errorMsg",errorMsg);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

        else {
            //save the book list information into session
            request.getSession().setAttribute("bookList",bookList);
            response.sendRedirect(request.getContextPath()+"/result.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
