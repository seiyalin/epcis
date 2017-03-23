/*package org.oliot.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.oliot.epcis.serde.mysql.dao.user.impl.UserDao;
import org.oliot.model.mysqlservice.User;
import org.oliot.model.mysqlservice.privilege.Privilege;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

*//** 
 * 初始化权限 
 * @author LUCKY 
 * 
 *//*  
@Component  
public class Installer {  
      
    @Resource  
    private SessionFactory sessionFactory;  
      
    @Transactional 
    @Test 
    public void install(){  
    	
    	ApplicationContext at =new ClassPathXmlApplicationContext("applicationContext.xml");
    	sessionFactory = (SessionFactory) at.getBean("sessionFactory");
//		UserDao userDao = (UserDao) at.getBean("userDao");
          
        //1.获得session  
        Session session = sessionFactory.openSession();  
          
        //2.保存超级管理员用户  
        User user = new User();  
        user.setUserName("屈岳888888");
        user.setPassWord("root");
        session.save(user);//保存  
          
        //3.保存权限数据  
        Privilege menu,menu1,menu2,menu3;  
          
//        menu = new Privilege("ahahkfahkhk",null,null);  
        menu = new Privilege("系统管理",null,null);  
        menu1 = new Privilege("岗位管理","/role_list",menu);  
        menu2 = new Privilege("部门管理","/department_list",menu);  
        menu3 = new Privilege("用户管理","/user_list",menu);  
        session.save(menu);  
        session.save(menu1);  
        session.save(menu2);  
        session.save(menu3);  
          
        session.save(new Privilege("岗位列表", "/role_list", menu1));  
        session.save(new Privilege("岗位删除", "/role_delete", menu1));  
        session.save(new Privilege("岗位添加", "/role_add", menu1));  
        session.save(new Privilege("岗位修改", "/role_edit", menu1));  
          
        session.save(new Privilege("部门列表", "/department_list", menu2));  
        session.save(new Privilege("部门删除", "/department_delete", menu2));  
        session.save(new Privilege("部门添加", "/department_add", menu2));  
        session.save(new Privilege("部门修改", "/department_edit", menu2));  
          
        session.save(new Privilege("用户列表", "/user_list", menu3));  
        session.save(new Privilege("用户删除", "/user_delete", menu3));  
        session.save(new Privilege("用户添加", "/user_add", menu3));  
        session.save(new Privilege("用户修改", "/user_edit", menu3));  
        session.save(new Privilege("初始化密码", "/user_initPassword", menu3));  
          
        session.save(menu);  
        session.save(menu1);  
        session.save(menu2);  
        session.save(menu3);  
    }  
      
    public static void main(String[] args){  
        //执行方法初始化数据  
        ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
        Installer installer = (Installer) aContext.getBean("installer");  
        installer.install();  
    }  
}  
*/