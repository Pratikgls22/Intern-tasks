package manyToMany.controller;

import manyToMany.dao.AuthorDao;
import manyToMany.vo.AuthorVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorController" ,value = "/AuthorController")
public class AuthorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("f");
        if(flag.equals("fAuthor")){
            insert(req,resp);
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        AuthorVo authorVo = new AuthorVo();
        authorVo.setAuthorName(req.getParameter("aname"));
        AuthorDao authorDao = new AuthorDao();
        authorDao.save(authorVo);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
