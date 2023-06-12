package user.create.responseDTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

//REQUEST
@Data
public class UserDTO {
	
	private String id_user;

	private String name;

	private String email;

	private String password;
	
	private List<PhoneDTO> phones;
	
	private LocalDate created;
	
	private LocalDate modified;
	
	private LocalDate LastLogin;
	
	private String token;
	
	private Boolean status = true;
	
}
