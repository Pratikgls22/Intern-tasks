package Controller;

import Dao.RegDao;
import Vo.RegVo;

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

        if(flag.equals("insert")){
            insert(request,response);
            search(request,response);
        }
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
        httpSession.setAttribute("searchList",searchList);
        response.sendRedirect("searchList.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
