package esprit.tn.infini.pidev.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.infini.pidev.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
