package oneToMany.controller;

import oneToMany.dao.CompanyDao;
import oneToMany.dao.EmpDao;
import oneToMany.vo.CompanyVo;
import oneToMany.vo.EmpVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpController", value = "/EmpController")
public class EmpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if(flag.equals("insert")){
            insert(req,resp);
            search(req,resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        List info = new ArrayList();

        EmpDao empDao = new EmpDao();
        info = empDao.search();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("Data",info);
        resp.sendRedirect("search.jsp");
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        EmpVo empVo = new EmpVo();
        CompanyVo companyVo = new CompanyVo();
        empVo.setFristname(req.getParameter("firstname"));
        empVo.setLastname(req.getParameter("lastname"));
        empVo.setEmail(req.getParameter("email"));
        companyVo.setDepartment(req.getParameter("department"));
        companyVo.setPost(req.getParameter("post"));

        EmpDao empDao = new EmpDao();
        empDao.save(empVo);
        CompanyDao companyDao = new CompanyDao();
        companyDao.save(companyVo);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
