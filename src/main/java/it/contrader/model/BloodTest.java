package it.contrader.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BloodTest {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float redBloodCell;
	private Float whiteBloodCell;
	private Float platelets;
	private Float hemoglobin;
	private Long idAdmin;
	private Long idUser;
	private Boolean isChecked;
	private String dateInsert;

}
