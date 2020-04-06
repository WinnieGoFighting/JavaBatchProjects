package controllers;
import domain.Course;
import domain.Login;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import service.StuService;
@Controller
@SessionAttributes(value={"stu","course"},types={Student.class,Course.class})
public class ClassRegistrationController {
    @Autowired
    public StuService stuService;

    @RequestMapping(value="/registerCourseProcess", method= RequestMethod.POST)
    public String processCourseRegistration(ModelMap m, Course course) {
        Student stu = (Student)m.get("stu");
        m.addAttribute("course",course);
        System.out.println(stu);
        boolean isSuccess = stuService.registerCourse(stu,course);
        return isSuccess==true?"success":"failure";
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String processLogOut(SessionStatus status) {
        //invalidate session
        status.setComplete();
        return "login";
    }

}
