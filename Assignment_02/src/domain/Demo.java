package domain;

import java.io.Serializable;
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

public class Demo {
	//session.save()
		@Test
		public void demo1() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setName("bbb");
			
			Serializable id = session.save(employee);
			System.out.println(id);
			System.out.println(employee);
			
			tx.commit();
			session.close();
		}
		
		@Test
		public void demo2() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			Employee e1 = session.get(Employee.class,1);
			System.out.println(e1);
			
			Employee e2 = session.get(Employee.class,1);
			System.out.println(e2);
			
			tx.commit();
			session.close();
		}
		
		//update()
		@Test
		public void demo3() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			//search and update
			Employee e = session.get(Employee.class, 2);
			e.setName("aa");
			session.update(e);
			tx.commit();
			session.close();
			
		}
		
		//delete()
		@Test
		public void demo4() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			//search and delete 推荐使用，利于后面的级联删除
			Employee e = session.get(Employee.class, 1);
			session.delete(e);
	
			tx.commit();
			session.close();	
		}

		//saveOrUpdate()
		@Test
		public void demo5() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			//save object
			Employee e1 = new Employee();
			e1.setName("fff");
			session.saveOrUpdate(e1);

			//update object
			Employee e2 = new Employee();
			e2.setEmployee_Id(2);
			e2.setName("bbbb");
			session.saveOrUpdate(e2);
		
			tx.commit();
			session.close();			
		}
		
		//search all results
		@Test
		public void demo6() {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			//use HQL
			Query query = session.createQuery("from Employee");
			List<Employee> elist = query.list();
			for (Employee e: elist)
				System.out.println(e);
			
			//use SQL
			SQLQuery sql_query = session.createSQLQuery("SELECT * FROM EMPLOYEE");
			List<Object[]> list = sql_query.list();
			for (Object[] objs:list)
				System.out.println(Arrays.toString(objs));			
			tx.commit();
			session.close();			
		}
		
		@Test
		public void demo7() {
			Session session = HibernateUtils.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			Employee e = session.get(Employee.class, 1);
			System.out.println(e);
			
			tx.commit();			
		}	
}
