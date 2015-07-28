package com.shengsiyuan.service.impl;

import java.util.List;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.dao.impl.PersonDAOImpl;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.service.PersonService;

public class PersonServiceImpl implements PersonService {

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		PersonDAO personDAO=new PersonDAOImpl();
		personDAO.savePerson(person);
	}

	public List<Person> listAllPersons() {
		// TODO Auto-generated method stub
		PersonDAO personDAO=new PersonDAOImpl();
		
		return personDAO.listAllPersons();
	}

	public void removePerson(String id) {
		// TODO Auto-generated method stub
		PersonDAO personDAO=new PersonDAOImpl();
		
		personDAO.removePerson(id);
	}

	public Person getSinglePersonById(String id) {
		// TODO Auto-generated method stub
		PersonDAO personDAO=new PersonDAOImpl();
		
		return personDAO.getSinglePersonById(id);
	}

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		PersonDAO personDAO = new PersonDAOImpl();
		
		personDAO.updatePerson(person);
	}

}
