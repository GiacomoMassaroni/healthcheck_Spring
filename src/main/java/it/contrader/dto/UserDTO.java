package it.contrader.dto;

import it.contrader.model.User.Usertype;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

	private Long id;

	private String email;

	private String password;

	private Usertype usertype;

}
