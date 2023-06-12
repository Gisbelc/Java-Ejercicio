package user.create.responseDTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReturnResponseDTO {

	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	private LocalDateTime LastLogin;
	
	private String token;
	
	private Boolean status = true;
	
}
