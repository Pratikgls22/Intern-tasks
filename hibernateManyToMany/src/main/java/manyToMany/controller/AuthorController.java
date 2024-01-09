package manyToMany.controller;

import manyToMany.dao.AuthorDao;
import manyToMany.dao.BookDao;
import manyToMany.vo.AuthorVo;
import manyToMany.vo.BookVo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "AuthorController" ,value = "/AuthorController")
public class AuthorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("f");
        if(flag.equals("fAuthor")){
            insert(req,resp);
            search(req,resp);
        } else if (flag.equals("update")) {
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int updateId = Integer.parseInt(req.getParameter("updateId"));
        String updateName = req.getParameter("updateAuthorName");
        String updateBookName = req.getParameter("updateBookName");

        AuthorVo authorVo = new AuthorVo();
        authorVo.setId(updateId);
        authorVo.setAuthorName(updateName);
        Set<AuthorVo> authorVoSet = new HashSet<>();
        authorVoSet.add(authorVo);

        AuthorDao authorDao = new AuthorDao();
        authorDao.update(authorVo);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
//        List data = new ArrayList<>();
        AuthorDao authorDao = new AuthorDao();
        List data = authorDao.search();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("searchList", data);
        System.out.println("data.size = " + data.size());
        resp.sendRedirect("search.jsp");

        BookDao bookDao = new BookDao();
        List list= bookDao.search();


    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        AuthorVo authorVo = new AuthorVo();
        authorVo.setAuthorName(req.getParameter("aname"));
        AuthorDao authorDao = new AuthorDao();
        authorDao.save(authorVo);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if(flag.equals("edit")){
            edit(req,resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int editId = Integer.parseInt(req.getParameter("id"));

        AuthorVo authorVo = new AuthorVo();
        authorVo.setId(editId);

        AuthorDao authorDao = new AuthorDao();
        List<AuthorVo> authorList = authorDao.edit(authorVo);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("data",authorList);

        BookDao bookDao = new BookDao();
        List listBook = bookDao.search();

        HttpSession httpSession1 = req.getSession();
        httpSession1.setAttribute("dataBook",listBook);

        resp.sendRedirect("edit.jsp");
    }
}
