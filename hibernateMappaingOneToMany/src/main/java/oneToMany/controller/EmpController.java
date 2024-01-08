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
        } else if (flag.equals("update")) {
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int updateId = Integer.parseInt(req.getParameter("id"));
        String updateFn = req.getParameter("firstname");
        String updateLn =  req.getParameter("lastname");
        String updateEmail = req.getParameter("email");
        String updateDepartment = req.getParameter("department");
        String updatePost = req.getParameter("post");

        EmpVo empVo = new EmpVo();
        empVo.setId(updateId);
        empVo.setFirstname(updateFn);
        empVo.setLastname(updateLn);

        CompanyVo companyVo = new CompanyVo();
        companyVo.setDepartment(updateDepartment);
        companyVo.setPost(updatePost);

        EmpDao empDao = new EmpDao();
        empDao.update(empVo);

        CompanyDao companyDao = new CompanyDao();
        companyDao.update(companyVo);

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        List info = new ArrayList();

        EmpDao empDao = new EmpDao();
        info = empDao.search();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("searchList",info);
        System.out.println("your data size:"+info.size());
        resp.sendRedirect("search.jsp");
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        EmpVo empVo = new EmpVo();
        CompanyVo companyVo = new CompanyVo();

        empVo.setFirstname(req.getParameter("firstname"));
        empVo.setLastname(req.getParameter("lastname"));
        empVo.setEmail(req.getParameter("email"));
        companyVo.setDepartment(req.getParameter("department"));
        companyVo.setPost(req.getParameter("post"));

        empVo.setCompany(companyVo);


        CompanyDao companyDao = new CompanyDao();
        companyDao.save(companyVo);
        EmpDao empDao = new EmpDao();
        empDao.save(empVo);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if (flag.equals("search")){
            search(req,resp);
        } else if (flag.equals("delete")) {
            delete(req,resp);
        } else if (flag.equals("edit")) {
            edit(req,resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int editId = Integer.parseInt(req.getParameter("id"));

        EmpVo empVo = new EmpVo();
        empVo.setId(editId);
        EmpDao empDao = new EmpDao();
        List<EmpVo> list = empDao.findById(empVo);
        list = empDao.edit(empVo);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("Data",editId);
        resp.sendRedirect("edit.jsp");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException                                                                                    {
        int deleteId = Integer.parseInt(req.getParameter("id"));
        EmpVo empVo = new EmpVo();
        empVo.setId(deleteId);
        EmpDao empDao = new EmpDao();

        List<EmpVo> findId = EmpDao.findById(empVo);
        EmpVo vo = findId.get(0);

        CompanyVo companyVo = vo.getCompany();
        CompanyDao companyDao = new CompanyDao();

        empDao.delete(empVo);
        companyDao.delete(companyVo);

        resp.sendRedirect("EmpController?flag=search");
    }
}
