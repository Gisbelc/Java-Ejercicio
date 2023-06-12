package user.create.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.create.responseDTO.ResponseDTO;
import user.create.responseDTO.ReturnResponseDTO;
import user.create.responseDTO.UserDTO;
import user.create.service.UserService;

@RestController
public class UserController {

	@Autowired
	public UserService serv;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDTO> saveDataUser(@RequestBody UserDTO userDto){
		
		ResponseDTO response = serv.saveUser(userDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<ReturnResponseDTO>> getDataService(){
		
		List<ReturnResponseDTO> response = serv.getDataUser();
		
		return  ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
