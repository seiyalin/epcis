package cn.itcast.a_hello;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App3 {
	
	private static SessionFactory sf;
	static  {
		
		// ����sf����
		sf = new Configuration().configure().buildSessionFactory();
	}

	//HQL��ѯ  ���ʺ������ݿ�����ġ�
	@Test
	public void testQuery() throws Exception {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// ������ѯ
		//Employee emp = (Employee) session.get(Employee.class, 1);
		
		// HQL��ѯ����ѯȫ��
		Query q = session.createQuery("from Employee where empId=1 or empId=2");
		List<Employee> list = q.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	

	//QBC��ѯ  , query by criteria  ��ȫ�������Ĳ�ѯ
	@Test
	public void testQBC() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		// ����
		criteria.add(Restrictions.eq("empId", 1));
		// ��ѯȫ��
		List<Employee> list = criteria.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	//sQL
	@Test
	public void testSQL() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		// ��ÿһ�м�¼��װΪ�������飬����ӵ�list����
//		SQLQuery sqlQuery = session.createSQLQuery("select * from employee");
		// ��ÿһ�м�¼��װΪ ָ���Ķ�������
		SQLQuery sqlQuery = session.createSQLQuery("select * from employee").addEntity(Employee.class);
		List list = sqlQuery.list();
		
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}












