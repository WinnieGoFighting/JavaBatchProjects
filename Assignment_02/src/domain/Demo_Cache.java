package domain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import utils.HibernateUtils;

public class Demo_Cache {
	
	//demo1() demonstrate the use of first-level cache, which exists within one session
	@Test
	public void demo1() {
		Session s1 = HibernateUtils.openSession();
		Transaction tx = s1.beginTransaction();

		//Only one SQL is executed due to first level cache within session
		Employee e1 = s1.get(Employee.class, 1);
		System.out.println(e1);
		Employee e2 = s1.get(Employee.class, 1);
		System.out.println(e2);
		
		tx.commit();
		s1.close();
	}
	//demo2() demonstrate the use of second-level cache, which exists within one session factory
	@Test
	public void demo2() {
		Session s1 = HibernateUtils.openSession();
		Transaction tx = s1.beginTransaction();
	
		Employee e1 = s1.get(Employee.class,1);	
		System.out.println(e1);
		
		tx.commit();
		s1.close();
		
		//Only one SQL is executed due to second level cache within session factory
		Session s2 = HibernateUtils.openSession();
		tx = s2.beginTransaction();	
		
		Employee e2 = s2.get(Employee.class,1);	
		System.out.println(e1);
		
		tx.commit();
		s2.close();					
	}
}
