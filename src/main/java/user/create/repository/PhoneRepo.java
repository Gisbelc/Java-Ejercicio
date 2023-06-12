package user.create.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.create.model.Phone;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, String> {

	
}
