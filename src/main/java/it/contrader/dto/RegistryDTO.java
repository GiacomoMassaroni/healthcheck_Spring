package it.contrader.dto;

import it.contrader.model.Registry;
import it.contrader.model.User.Usertype;
import lombok.*;
import it.contrader.model.Registry.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistryDTO {

	private Long id;

	private String name;

	private String surname;

	private String birthDate;

	private Gender gender;

	private String nationality;

	private String city;

	private String address;

	private String cf;

	private String bg;

	private Long idUser;

}

