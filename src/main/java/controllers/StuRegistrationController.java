package controllers;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.StuService;
import service.StuServiceImpl;

import javax.annotation.Resource;

@Controller
public class StuRegistrationController {
    @Autowired
    public StuService stuService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new Student());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") Student stu) {
        stuService.register(stu);
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("message", "Registration Successful! Please log in now");
        return mav;
    }
}
