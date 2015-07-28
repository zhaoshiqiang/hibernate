package com.shengsiyuan.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static
	{
		try {
			
			sessionFactory=new Configuration().configure().
						buildSessionFactory();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//session就相当于一个数据库的连接
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}
	
	public static void close(Session session)
	{
		if(null != session)
		{
			session.close();
		}
	}
}
