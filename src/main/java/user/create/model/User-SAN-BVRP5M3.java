package user.create.model;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String id_user = UUID.randomUUID().toString();

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
}
