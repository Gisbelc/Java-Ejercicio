package user.create.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_created")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String user_id = UUID.randomUUID().toString();
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	//return
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "modified")
	private LocalDateTime modified;
	
	@Column(name = "lastlogin")
	private LocalDateTime LastLogin;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "status")
	private Boolean status = true;
	
}
