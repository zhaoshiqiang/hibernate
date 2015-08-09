package com.shengsiyuan.dao;

import java.util.List;

import com.shengsiyuan.model.Person;

public interface PersonDAO {
	
	public void savePerson(Person person);
	
	public List<Person> listAllPersons();
	
	public void removePerson(int id);
	
	public Person getSinglePersonById(int id);
	
	public void updatePerson(Person person);
}
