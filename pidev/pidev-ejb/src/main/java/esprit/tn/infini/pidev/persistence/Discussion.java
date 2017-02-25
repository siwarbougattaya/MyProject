package esprit.tn.infini.pidev.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Discussion
 *
 */
@Entity

public class Discussion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="user_id1")
	private User user1;
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="user_id2")
	private User user2;
	private static final long serialVersionUID = 1L;

	public Discussion() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}   
	public User getUser2() {
		return this.user2;
	}

	public Discussion(int id, String message, User user1, User user2) {
		super();
		this.id = id;
		this.message = message;
		this.user1 = user1;
		this.user2 = user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
   
}
