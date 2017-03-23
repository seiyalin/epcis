package cn.edu.fudan.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	public Person getPerson(int id) {
		return personDao.selectPersonById(id);
	}
}