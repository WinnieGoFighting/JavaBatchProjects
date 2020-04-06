package dao;

import domain.Login;
import domain.Student;

public interface StuDao {

    public void register(Student stu);
    public Student validate(Login login);
}
