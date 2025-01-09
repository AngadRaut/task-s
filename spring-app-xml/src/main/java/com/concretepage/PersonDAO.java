package com.concretepage;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.concretepage.entity.Person;

@Transactional
public class PersonDAO {
	private HibernateTemplate  hibernateTemplate;
	public PersonDAO(HibernateTemplate  hibernateTemplate) {

	  this.hibernateTemplate = hibernateTemplate;
	}
	public Person getPersonById(int pid) {
		return hibernateTemplate.get(Person.class, pid);
	}
	public List<Person> getAllPersons() {
		return hibernateTemplate.loadAll(Person.class);
	}	
	public void addPerson(Person person) {
		hibernateTemplate.save(person);
	}
	public void updatePerson(Person person) {
		Person p = getPersonById(person.getPid());
		p.setName(person.getName());
		p.setCity(person.getCity());
		hibernateTemplate.update(p);
	}
	public void deletePerson(int pid) {
		hibernateTemplate.delete(getPersonById(pid));
	}
} 
