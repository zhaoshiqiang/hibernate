package com.shengsiyuan.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.util.HibernateUtil;

public class PersonDAOImpl implements PersonDAO{

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		
		try 
		{
			session.save(person);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.close(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		
		List<Person> list=null;
		
		try {
			//Person是类的名字而不是表的名字，既然是类的名字就需要严格区分大小写
			Query query=session.createQuery("from Person");
			
			list=(List<Person>)query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(null != tx)
			{
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
		
		return list;
	}

	public void removePerson(int id) {

		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		
		try {
			
			Person person=(Person)session.get(Person.class,id);
			session.delete(person);
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null)
			{ 
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
		
	}

	public Person getSinglePersonById(int id) {
		
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		
		Person person = null;
		
		try {
			person=(Person)session.get(Person.class,id);			
			tx.commit();
			
		} catch (Exception e) {

			if(tx != null)
			{
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
		
		return person;
	}

	public void updatePerson(Person person) {
		Session session =HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		
		try {
			
			session.update(person);
			tx.commit();
			
		} catch (Exception e) {
			
			if(tx != null)
			{
				tx.rollback();
			}
		}finally{
			HibernateUtil.close(session);
		}
	}

}
