package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import it.contrader.model.Registry.Gender;
import it.contrader.dto.RegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/registry")
public class RegistryController {

    @Autowired
    private RegistryService service;
    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("registryDto", service.read(id));
        return "/registry/updateregistry";
    }

    @PostMapping("/update")
    public String update(
            HttpServletRequest request,
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("birthDate") String birthDate,
            @RequestParam("gender") Gender gender,
            @RequestParam("nationality") String nationality,
            @RequestParam("city") String city,
            @RequestParam("address") String address,
            @RequestParam("cf") String cf,
            @RequestParam("bg") String bg,
            @RequestParam("idUser") Long idUser
    ) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        RegistryDTO dto = new RegistryDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setSurname(surname);
        dto.setBirthDate(birthDate);
        dto.setGender(gender);
        dto.setNationality(nationality);
        dto.setCity(city);
        dto.setAddress(address);
        dto.setCf(cf);
        dto.setBg(bg);
        dto.setIdUser(idUser);

        service.update(dto);
        request.getSession().setAttribute("registryDto", service.read(id));
        if(user.getUsertype().toString().equals("SUPER")){
            return "/user/users";
        }else{
            return "/user/readuser";
        }

    }
    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("registryDto", service.read(id));
        return "/registry/readregistry";
    }

    @PostMapping("/insert")
    public String insert(
        HttpServletRequest request,
        @RequestParam("name") String name,
        @RequestParam("surname") String surname,
        @RequestParam("birthDate") String birthDate,
        @RequestParam("gender") Gender gender,
        @RequestParam("nationality") String nationality,
        @RequestParam("city") String city,
        @RequestParam("address") String address,
        @RequestParam("cf") String cf,
        @RequestParam("bg") String bg,
        @RequestParam("idUser") Long idUser
    ) {
        RegistryDTO dto = new RegistryDTO();
        dto.setName(name);
        dto.setSurname(surname);
        dto.setBirthDate(birthDate);
        dto.setGender(gender);
        dto.setNationality(nationality);
        dto.setCity(city);
        dto.setAddress(address);
        dto.setCf(cf);
        dto.setBg(bg);
        dto.setIdUser(idUser);
        service.insert(dto);
        return "/homeuser";
    }


}
