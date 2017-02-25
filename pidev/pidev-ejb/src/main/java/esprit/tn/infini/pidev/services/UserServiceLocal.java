package esprit.tn.infini.pidev.services;

import java.util.List;

import javax.ejb.Local;

import esprit.tn.infini.pidev.persistence.User;


@Local
public interface UserServiceLocal {
	public void create(User user);
	public User authentificate(String login, String password);
	public List<User> findAll();
	public User find(int id);
	public User findByLogin(String login);

	public void delete(User u);
	public void update(User u);
	public void closeUser(int idUser);
	public void openUser(int idUser);
	public void upgrade(int idUser);
	public void downgrad(int idUser);
	
}
