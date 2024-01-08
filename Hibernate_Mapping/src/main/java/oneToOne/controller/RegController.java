package oneToOne.controller;

import oneToOne.dao.LoginDao;
import oneToOne.dao.RegDao;
import oneToOne.vo.LoginVo;
import oneToOne.vo.RegVo;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegController",value = "/RegController")
public class RegController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if (flag.equals("search")) {
            search(req,resp);
        } else if (flag.equals("delete")) {
            delete(req,resp);
        }
        else if(flag.equals("edit")){
            edit(req,resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int editId = Integer.parseInt(req.getParameter("id"));

        RegVo regVo = new RegVo();
        regVo.setId(editId);

        RegDao regDao = new RegDao();
        List<RegVo> list = regDao.findById(regVo);
//        list = regDao.edit(regVo);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("Data",editId);

        resp.sendRedirect("edit.jsp");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("id"));

        RegVo regVo = new RegVo();
        regVo.setId(deleteId);

        RegDao regDao = new RegDao();

        List<RegVo> findId=regDao.findById(regVo);

        RegVo vo = findId.get(0);

        LoginVo loginVo = vo.getLo                                                                                                                                              ginVo();

        LoginDao loginDao =new LoginDao();

        regDao.delete(regVo);
        loginDao.delete(loginVo);


        resp.sendRedirect("RegController?flag=search");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if(flag.equals("insert")){
            insert(req,resp);
            search(req,resp);
        } else if (flag.equals("update")) {
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
            int updateId = Integer.parseInt(req.getParameter("id"));
        String updateFn =req.getParameter("firstname");
        String updateLn = req.getParameter("lastname");
        String updateEmail = req.getParameter("email");
        String updatePass = req.getParameter("pass");

        RegVo regVo = new RegVo();
        regVo.setId(updateId);
        regVo.setFirstname(updateFn);
        regVo.setLastname(updateLn);
        RegDao regDao = new RegDao();
        regDao.update(regVo);

//        HttpSession httpSession = req.getSession();
//        httpSession.setAttribute("updateList",);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List data = new ArrayList();

        RegDao regDao =  new RegDao();
        data = regDao.search();
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("searchList",data);
        resp.sendRedirect("search.jsp");

    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RegVo regVo = new RegVo();
        RegDao regDao = new RegDao();
        LoginVo loginVo = new LoginVo();
        LoginDao loginDao = new LoginDao();

        loginVo.setEmail(req.getParameter("email"));
        loginVo.setPass(req.getParameter("pass"));
        loginDao.save(loginVo);

        regVo.setFirstname(req.getParameter("firstname"));
        regVo.setLastname(req.getParameter("lastname"));
        regVo.setLoginVo(loginVo);

        regDao.save(regVo);

    }
}
