package user.create.responseDTO;

import lombok.Data;

@Data
public class PhoneDTO {


	private String phone_id;
	
	private String user_id;
	
	public String numberPhone;
	
	public String cityCode;
	
	public String countryCode;
}
