package manyToMany.controller;

import manyToMany.dao.BookDao;
import manyToMany.vo.BookVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if (flag.equals("fBook")) {
            insert(req, resp);
            search(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        BookDao bookDao = new BookDao();
        List list = bookDao.search();
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookVo bookVo = new BookVo();
        bookVo.setBName(req.getParameter("bname"));
        BookDao bookDao = new BookDao();
        bookDao.save(bookVo);

        resp.sendRedirect("author.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
