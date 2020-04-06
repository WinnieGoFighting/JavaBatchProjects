package domain;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import utils.HibernateUtils;

public class DemoManyToMany {
	
	//保存多条记录：保存多个employees和projects
	@Test
	public void demo1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setName("aaa");
		Employee e2 = new Employee();
		e2.setName("bbb");
		
		Project p1 = new Project();
		p1.setTitle("111");
		
		Project p2 = new Project();
		p2.setTitle("222");
		
		Project p3 = new Project();
		p3.setTitle("333");
		
		//双向关系
		e1.getProjects().add(p1);
		e1.getProjects().add(p2);
		e2.getProjects().add(p2);
		e2.getProjects().add(p3);
		
		p1.getEmployees().add(e1);
		p2.getEmployees().add(e1);
		p2.getEmployees().add(e2);
		p3.getEmployees().add(e2);
		
		//保存操作：多对多建立了双向的关系必须有一方放弃外键维护
		//一般让被动方 放弃外键维护权
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		tx.commit();
		
		
	}
}
