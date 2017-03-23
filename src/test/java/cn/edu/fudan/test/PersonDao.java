package cn.edu.fudan.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("singleton")
@Repository
public class PersonDao {

	public Person selectPersonById(int id) {
		Person p = new Person();
		p.setId(id);
		p.setName("Person name");
		return p;
	}
}