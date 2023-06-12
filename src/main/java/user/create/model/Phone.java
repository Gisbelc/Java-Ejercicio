package user.create.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user_phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private String phone_id = UUID.randomUUID().toString();

	@Column(name = "numberphone")
	private String numberPhone;

	@Column(name = "citycode")
	private String cityCode;

	@Column(name = "countrycode")
	private String countryCode;
}
