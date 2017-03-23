package cn.itcast.a_hello;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	@Test
	public void testHello() throws Exception {
		// ����
		Employee emp = new Employee();
		//ֻ�����ֺ���ĸ�Ż��ύ����ݿ⣬���Ĳ���
		emp.setEmpName("屈岳 qq群");
		emp.setWorkDate(new Date());
		
		// ��ȡ���������ļ��Ĺ��������
		Configuration config = new Configuration();
		config.configure();  // Ĭ�ϼ���src/hibenrate.cfg.xml�ļ�
		// ����session�Ĺ�������
		SessionFactory sf = config.buildSessionFactory();
		// ����session (���һ���Ự������ݿ����ӵĻỰ)
		Session session = sf.openSession();
		// ��������
		Transaction tx = session.beginTransaction();
		//����-��ݿ�
		session.save(emp);
		// �ύ����
		tx.commit();
		// �ر�
		session.close();
		sf.close();
	}
}
