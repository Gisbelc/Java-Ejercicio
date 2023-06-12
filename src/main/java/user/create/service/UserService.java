package user.create.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import user.create.mapper.PhoneDTOToPhone;
import user.create.mapper.UserDTOToUser;
import user.create.mapper.UserDTOtoRequest;
import user.create.model.Phone;
import user.create.model.User;
import user.create.repository.PhoneRepo;
import user.create.repository.UserRepo;
import user.create.responseDTO.PhoneDTO;
import user.create.responseDTO.ResponseDTO;
import user.create.responseDTO.ReturnResponseDTO;
import user.create.responseDTO.StatusDTO;
import user.create.responseDTO.UserDTO;

@Service
public class UserService {

	@Autowired
	public UserRepo userRepo;

	@Autowired
	public PhoneRepo phoneRepo;

	@Autowired
	UserDTOToUser userMapper;

	@Autowired
	PhoneDTOToPhone phoneMapper;

	@Autowired
	UserDTOtoRequest mapper;

	// Validación de email

	public boolean isEmailValid(String email) {

		List<User> userList = userRepo.findByEmail(email);

		for (User e : userList) {
			if (e.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	// Validación de email con ReGex
	public boolean validateEmailWithRegex(String email) {

		String regexEmail = "^[\\w.-]+@[a-zA-Z_-]+?(?:\\.[a-zA-Z]{2,})+$";

		if (email.matches(regexEmail)) {
			return true;
		}

		return false;
	}

	// Validación de password con ReGex

	public boolean validatePasswordWithRegex(String password) {

		String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d).*$";

		if (password.matches(regexPassword)) {
			return true;
		}

		return false;
	}

	public String generateJwt() {

		User user = new User();
		int jwtMinute = 60;
		String secretCode = "test";

		String jwt = Jwts.builder().setSubject(user.getToken()) // Establece el sujeto del token
				.setExpiration(new Date(System.currentTimeMillis() + jwtMinute * 60000)) // Fecha de expiración
				.signWith(SignatureAlgorithm.HS512, secretCode) // Firma el token con el algoritmo HS512 y la clave
																// secreta
				.compact();

		return jwt;
	}

	// guardar usuario

	public ResponseDTO saveUser(UserDTO userDto) {

		ResponseDTO response = new ResponseDTO();

		if (validateEmailWithRegex(userDto.getEmail()) && validatePasswordWithRegex(userDto.getPassword())) {

			if (isEmailValid(userDto.getEmail())) {
				User user = userMapper.map(userDto);
				generateJwt();
				userRepo.save(user);

				List<Phone> phones = new ArrayList<>();
				for (PhoneDTO phoneDto : userDto.getPhones()) {
					Phone phone = phoneMapper.map(phoneDto);
					phones.add(phone);
					phoneRepo.save(phone);
				}
				response.setMessage(new StatusDTO("200", "Registered user successfully!"));
			} else {
				response.setMessage(new StatusDTO("422", "There is already an associated email."));
			}
		} else {
			response.setMessage(new StatusDTO("null",
					"Please, verify that your email or password complies with the correct format."));
		}
		return response;

	}

	// devolver user

	public List<ReturnResponseDTO> getDataUser() {
		
		List<User> userList = userRepo.findAll();
		
		List<ReturnResponseDTO> data = userList.stream().map(user -> {
			
			ReturnResponseDTO response = new ReturnResponseDTO();
			response.setCreated(user.getCreated());
			response.setLastLogin(user.getLastLogin());
			response.setModified(user.getModified());
			response.setStatus(user.getStatus());
			response.setToken(user.getToken());

			return response;
		}).collect(Collectors.toList());

		return data;
	}

}
