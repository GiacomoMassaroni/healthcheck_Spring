package it.contrader.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodTestDTO {

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
