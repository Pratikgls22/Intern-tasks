package com.controller;

import com.Dao.RegDao;
import com.model.RegVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegController {
    @Autowired
    RegDao regDao;
    @RequestMapping(value = "load.html", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("Register","RegVo",new RegVo());
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute RegVo regVo){
        regDao.insert(regVo);
        return new ModelAndView("redirect:/search.html");
    }
    @RequestMapping(value = "search.html", method = RequestMethod.GET)
    public ModelAndView serach(){
        List searchList = regDao.search();
        return new ModelAndView("search","SearchList",searchList);
    }
    @RequestMapping(value = "delete.html",method = RequestMethod.GET)
    public ModelAndView delete(@ModelAttribute RegVo regVo, HttpServletRequest request,@RequestParam int id){
        regVo.setId(id);
        regDao.delete(regVo);
        return new ModelAndView("redirect:/search.html");
    }

    @RequestMapping(value = "edit.html",method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute RegVo regVo, HttpServletRequest request,@RequestParam int id){
        regVo.setId(id);
        List<RegVo> editUser = regDao.edit(regVo);
        RegVo vo = editUser.get(0);
        return new ModelAndView("Register", "RegVo",vo);
    }
}

