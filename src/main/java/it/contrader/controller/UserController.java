package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import it.contrader.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private RegistryService registryService;

	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password) {

		try{
			UserDTO userDTO = service.findByEmailAndPassword(email, password);
			request.getSession().setAttribute("user", userDTO);

			switch (userDTO.getUsertype()) {
				case SUPER:
					return "homesuper";

				case ADMIN:
					return "homeadmin";

				case USER:
					return "homeuser";

				default:
					return "index";
			}
		}catch (Exception e){
			request.setAttribute("error","Email o password non corretti");
			return "index";
		}
	}

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "/user/users";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		service.delete(id);
		setAll(request);
		if(user.getUsertype().toString().equals("SUPER")){
			return "/user/users";
		}else{
			return "index";
		}
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "/user/updateuser";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {

		UserDTO user = (UserDTO) request.getSession().getAttribute("user");
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		service.update(dto);
		if(user.getUsertype().toString().equals("SUPER")){
			setAll(request);
			return "/user/users";
		}else{
			request.getSession().setAttribute("dto", service.read(id));
			return "/user/readuser";
		}

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {
		UserDTO dto = new UserDTO();
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		service.insert(dto);
		setAll(request);
		return "/user/users";
	}

	@PostMapping("/register")
	public String register(HttpServletRequest request, @RequestParam("email") String email,
						 @RequestParam("password") String password, @RequestParam("usertype") Usertype usertype) {
		UserDTO dto = new UserDTO();
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setUsertype(usertype);
		service.insert(dto);
		UserDTO loginDTO = service.findByEmailAndPassword(email, password);
		request.getSession().setAttribute("user", loginDTO);
		return "/registry/insertregistry";
	}



	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		request.getSession().setAttribute("registryDto", registryService.read(id));
		return "/user/readuser";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}


	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
