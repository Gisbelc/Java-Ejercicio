package user.create.mapper;

import org.springframework.stereotype.Component;

import user.create.model.User;
import user.create.responseDTO.ReturnResponseDTO;

@Component
public class UserDTOtoRequest implements IMapper<ReturnResponseDTO,User> {

	@Override
	public User map(ReturnResponseDTO in) {
		User response = new User();
		response.setCreated(in.getCreated());
		response.setLastLogin(in.getLastLogin());
		response.setModified(in.getModified());
		response.setStatus(in.getStatus());
		response.setToken(in.getToken());
		return response;
	}

	public User map(User user, Class<User> class1) {
		// TODO Auto-generated method stub
		return null;
	}


}
