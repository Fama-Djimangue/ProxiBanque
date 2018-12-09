package sn.objis.proxibanquev3.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User  implements Serializable{
  @Id
	private String username;
	private String password;
	private boolean actived=true;
	
	@ManyToMany
	@JoinColumn(name="USERS_ROLES")
	private Collection<Role> roles;  // un User peut avoir plusieurs roles
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = new HashSet<>();
	}
	public User(String username, String password, boolean actived, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.roles = new HashSet<>();
	}
	public User(String username, String password,boolean actived) {
		super();
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.roles = new HashSet<>();
	}
	
	@Override
	public String toString() {
		return "" + username + "";
	}
	
	
	
}
