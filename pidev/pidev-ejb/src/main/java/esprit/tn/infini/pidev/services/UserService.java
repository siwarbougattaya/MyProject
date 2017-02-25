package esprit.tn.infini.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import esprit.tn.infini.pidev.persistence.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote, UserServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public UserService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(User user) {
		user.setBaned(true);
	    user.setRole(false);
		em.persist(user);		
	}

	@Override
	public User authentificate(String login, String password) {
		Query query = em.createQuery("select u from User u where u.login=:param1 and u.password=:param2");

		query.setParameter("param1", login).setParameter("param2", password);
		User user = null;
		try {
			user = (User) query.getSingleResult();

		} catch (Exception e) {

			System.out.println("error " + e.getMessage());
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return em.createQuery("select u from User u", User.class).getResultList();

	}

	@Override
	public User find(int id) {
		return em.find(User.class, id);

	}

	@Override
	public User findByLogin(String login) {
		Query q= em.createQuery("select u from User u where u.login=:x");
		q.setParameter("x", login);
	    return (User) q.getResultList().get(0);
	}

	@Override
	public void delete(User u) {
		em.remove(em.merge(u));
		
	}

	@Override
	public void update(User u) {
		em.merge(u);	
		
	}

	@Override
	public void closeUser(int idUser) {
		User u=find(idUser);
		u.setBaned(true);
				
	}

	@Override
	public void openUser(int idUser) {
		User u=find(idUser);
		u.setBaned(false);		
	}

	@Override
	public void upgrade(int idUser) {
		User u =find(idUser);
		u.setRole(true);		
	}

	@Override
	public void downgrad(int idUser) {
		User u =find(idUser);
		u.setRole(false);		
	}

	

}
