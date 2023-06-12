package user.create.mapper;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import user.create.model.User;
import user.create.responseDTO.UserDTO;

@Component
public class UserDTOToUser implements IMapper<UserDTO, User> {
	
    User user = new User();
	
    public String generateJwt() {
  
        String secretCode = "test";

        String jwt = Jwts.builder()
                .setSubject(user.getToken()) // Establece el sujeto del token
                .setExpiration(new Date(System.currentTimeMillis())) // Fecha de expiración
                .signWith(SignatureAlgorithm.HS512, secretCode) // Firma el token con el algoritmo HS512 y la clave secreta
                .compact();

        return jwt;
    }

	@Override
	public User map(UserDTO in) {
		
		user.setEmail(in.getEmail());
		user.setUser_id(in.getId_user());
		user.setName(in.getName());
		user.setPassword(in.getPassword());
		user.setCreated(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		user.setModified(LocalDateTime.now());
		user.setStatus(true);
		user.setToken(generateJwt());
		
		return user;
	}

}
