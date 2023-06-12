package user.create.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.create.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	public List<User> findByEmail(String correo);
	

}
