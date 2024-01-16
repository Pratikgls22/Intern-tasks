package com.controller;

import com.dao.InfoDao;
import com.dao.UserDao;
import com.model.Info;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private InfoDao infoDao;

    @RequestMapping(value = "load", method = RequestMethod.GET)
    public ModelAndView load(){
        return new ModelAndView("Register","User",new User());
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute User user){
        Info info = user.getInfo();
        infoDao.insert(info);

        userDao.insert(user);

        return new ModelAndView("redirect:/search");
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView search(){
//        List<Info> infoList = infoDao.search();
        List<User> userList = userDao.search();
        System.out.println("userList.size() = " + userList.size());

        return new ModelAndView("search","searchList",userList);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ModelAndView delete(@ModelAttribute User user, HttpServletRequest request, @RequestParam int id){
        user.setUserId(id);
        userDao.delete(user);

        Info info = new Info();
        info.setUserInfoId(id);
        infoDao.delete(info);

        return new ModelAndView("redirect:/search");
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute User user, HttpServletRequest request, @RequestParam int id){
        Info info = new Info();

        user.setUserId(id);
        info.setUserInfoId(id);

        List<User> userList = userDao.findById(user);
        User user1 = userList.get(0);

        return new ModelAndView("Register","User", user1);
    }
}
