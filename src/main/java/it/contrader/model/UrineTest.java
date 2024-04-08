package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class UrineTest {
    private Float color;
    private Float ph;
    private Float protein;
    private Float hemoglobin;
    private Boolean isChecked;
    private String dateInsert;
    private String doctorName;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private Long idAdmin;
    private Long idUser;


    public UrineTest(Long id, Float color, Float ph, Float protein, Float hemoglobin, Long idAdmin, String doctorName, Long idUser, Boolean isChecked, String dateInsert) {
        this.Id = id;
        this.color = color;
        this.ph = ph;
        this.protein = protein;
        this.hemoglobin = hemoglobin;
        this.idAdmin = idAdmin;
        this.doctorName = doctorName;
        this.idUser = idUser;
        this.isChecked = isChecked;
        this.dateInsert = dateInsert;
    }


}
