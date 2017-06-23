package com.festival.controller;

import com.festival.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Registration {

    private final UserDAO userDAO;

    @Autowired
    public Registration(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping("/reg")
    public ModelAndView register(HttpServletResponse response, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Boolean added;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String secondname = request.getParameter("secondname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        added = userDAO.createUpdate(login,password,firstname,secondname,email,phone);
        mv.setViewName("login");
        if (added){
            mv.addObject("error", "New user registered!");
        }else {
            mv.addObject("error","Such user already exist!");
        }
        return mv;
    }

}
