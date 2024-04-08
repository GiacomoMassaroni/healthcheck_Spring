package it.contrader.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Registry {
	public enum Gender {
		MASCHIO, FEMMINA;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String surname;
	@Column(name= "birthDate")
	private String birthDate;

	private Gender gender;

	private String nationality;

	private String city;

	private String address;

	@Column(unique = true)
	private String cf;

	private String bg;
	@Column(name= "idUser")
	private Long idUser;




}
