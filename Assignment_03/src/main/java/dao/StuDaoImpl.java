package dao;
import domain.Course;
import domain.Login;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

public class StuDaoImpl implements StuDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private HibernateTemplate template;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Test
    public void register(Student stu) {
        template.save(stu);
    }

    public Student validate(Login login) {
        String p1 = login.getEmail();
        String p2 = login.getPassword();
        String sql = "select * from students where email='" + login.getEmail() + "' and password='" + login.getPassword()
                + "'";
        List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
        if(list.size()==0)
            return null;
        else {
            Student s = new Student();
            s.setId((Integer)list.get(0)[0]);
            s.setFirstName((String)list.get(0)[1]);
            s.setLastName((String)list.get(0)[2]);
            s.setEmail((String)list.get(0)[3]);
            s.setPassword((String)list.get(0)[4]);
            return s;
        }

    }

    public boolean registerCourse(Student stu, Course course) {
        Session s = sessionFactory.getCurrentSession();
        String p1 = course.getCourseName();
        String p2 = course.getDepartment();
        String sql = "select * from courses where coursename='" + course.getCourseName() + "' and department='" + course.getDepartment()
                + "'";
        List<Object[]> list = s.createSQLQuery(sql).list();
        if (list.size()==0)
            return false;
        else {
            Course c = new Course();
            c.setCid((Integer)list.get(0)[0]);
            c.setCourseName((String)list.get(0)[1]);
            c.setDepartment((String)list.get(0)[2]);
            //先查询再添加
            stu = s.get(Student.class,stu.getId());
            c = s.get(Course.class,c.getCid());
            stu.getCourses().add(c);
            return true;
        }
    }
}

