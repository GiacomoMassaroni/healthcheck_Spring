package it.contrader.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrineTestDTO {
    private Long Id;
    private Float color;
    private Float ph;
    private Float protein;
    private Float hemoglobin;
    private Long idAdmin;
    private String doctorName;
    private Long idUser;
    private Boolean isChecked;
    private String dateInsert;
}
