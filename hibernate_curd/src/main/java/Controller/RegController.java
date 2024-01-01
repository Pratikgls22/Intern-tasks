package Controller;

import Dao.RegDao;
import Vo.RegVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegController", value = "/RegController")
public class RegController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag = request.getParameter("flag");

        if (flag.equals("insert")) {
            insert(request, response);
            search(request, response);
        } else if (flag.equals("update")) {
            update(request,response);
            search(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
       int updateId = Integer.parseInt(request.getParameter("id"));
        String updatefn = request.getParameter("fn");
        String updateln = request.getParameter("ln");

        RegVo regVo =new RegVo();
        regVo.setId(updateId);
        regVo.setFirstname(updatefn);
        regVo.setLastname(updateln);

        RegDao regDao = new RegDao();
        regDao.update(regVo);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        RegVo regVo = new RegVo();
        regVo.setFirstname(request.getParameter("firstname"));
        regVo.setLastname(request.getParameter("lastname"));

        RegDao regDao = new RegDao();
        regDao.save(regVo);

    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List searchList = new ArrayList<>();

        RegDao regDao = new RegDao();
        searchList = regDao.search();

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("searchList", searchList);
        response.sendRedirect("searchList.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("id"));

        RegVo regVo = new RegVo();
        regVo.setId(deleteId);

        RegDao regDao = new RegDao();
        regDao.delete(regVo);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");

        if (flag.equals("search")){
            search(request,response);
        }else if (flag.equals("delete")) {
            delete(request,response);
            search(request,response);
        } else if (flag.equals("edit")) {
            edit(request,response);
            response.sendRedirect("editPage.jsp");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int editId = Integer.parseInt(request.getParameter("id"));

        RegVo regVo = new RegVo();
        regVo.setId(editId);

        List editData = new ArrayList();
        RegDao regDao = new RegDao();
        editData = regDao.edit(regVo);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("Data",editData);
    }
}
