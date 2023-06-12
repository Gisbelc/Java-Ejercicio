package user.create.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import user.create.model.Phone;
import user.create.responseDTO.PhoneDTO;

@Component
public class PhoneDTOToPhone implements IMapper<PhoneDTO, Phone> {

	@Override
	public Phone map(PhoneDTO in) {
		Phone phone = new Phone();
		phone.setCityCode(in.getCityCode());
		phone.setCountryCode(in.getCountryCode());
		phone.setNumberPhone(in.getNumberPhone());
		phone.setPhone_id(in.getPhone_id());
		return phone;
	}

	public Phone map(List<String> phones) {
		// TODO Auto-generated method stub
		return null;
	}

}
