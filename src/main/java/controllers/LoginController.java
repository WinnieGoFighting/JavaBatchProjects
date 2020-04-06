package controllers;
import domain.Login;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.StuService;
import service.StuServiceImpl;
import javax.annotation.Resource;
@Controller
@SessionAttributes(value={"stu"},types={Student.class})
public class LoginController {
    @Autowired
    public StuService stuService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login",new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("login") Login login, Model model) {
        ModelAndView mav = null;
        Student stu = stuService.validate(login);
        if (stu!=null) {
            mav = new ModelAndView("courseRegistration");
            model.addAttribute("stu",stu);
            mav.addObject("stu",stu);
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

}
