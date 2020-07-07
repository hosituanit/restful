package fa.training.restful.entity;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="users") 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String username;
	private String password;
	private String email;
	
	private String information;
	private LocalTime date;
	public long getId() { return id;
	}
	public void setId(long id) {
	this.id = id;
	}
	public String getUsername() { return username;
	
	}
	public void setUsername(String username) 
	{
	this.username = username;
	}
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) { 
		this.password = password;
	} 
}