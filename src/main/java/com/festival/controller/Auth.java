package com.festival.controller;

import com.festival.user.dao.UserDAO;
import com.festival.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class Auth {

    private final UserDAO userDAO;

    @Autowired
    public Auth(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam String action, HttpServletRequest req, HttpServletResponse resp) throws IOException{

        if (action.equals("Log In")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ModelAndView mv = new ModelAndView();
            User user = userDAO.getUser(login);
            if (userDAO.getUser(login) == null) {
                mv.setViewName("login");
                mv.addObject("error", "Combination of user/password is not found!");
                return mv;
            } else {
                String loginDB = user.getLogin();
                String passwordDB = user.getPassword();

                if (login.equals(loginDB) && password.equals(passwordDB)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("login", login);
                    mv.setViewName("index");
                    return mv;
                } else {
                    mv.addObject("error", "Combination of user/password is not found!");
                    mv.setViewName("login");
                    return mv;
                }
            }
        }else {
            ModelAndView mv = new ModelAndView();
            mv.setViewName("regwiz");
            return mv;
        }
    }



}
