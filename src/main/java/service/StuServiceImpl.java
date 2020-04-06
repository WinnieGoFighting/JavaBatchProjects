package service;
import dao.StuDaoImpl;
import domain.Course;
import domain.Login;
import domain.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Transactional
public class StuServiceImpl implements StuService{
    @Resource(name="stuDaoImpl")
    private StuDaoImpl stuDaoImpl;

    public StuDaoImpl getStuDaoImpl() {
        return stuDaoImpl;
    }

    public void setStuDaoImpl(StuDaoImpl stuDaoImpl) {
        this.stuDaoImpl = stuDaoImpl;
    }

    public void register(Student stu) {
        stuDaoImpl.register(stu);
    }
    public Student validate(Login login){
        return stuDaoImpl.validate(login);
    }
    public boolean registerCourse(Student stu, Course course) {
        return stuDaoImpl.registerCourse(stu,course);
    }
}
