package service;
import domain.Course;
import domain.Login;
import domain.Student;

public interface StuService {
    public void register(Student stu);
    public Student validate(Login login);
    public boolean registerCourse(Student stu, Course course);
}
