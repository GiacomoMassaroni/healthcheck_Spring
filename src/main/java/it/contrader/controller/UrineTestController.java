package it.contrader.controller;


import it.contrader.dto.UrineTestDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.service.UrineTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.persistence.NamedQuery;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/urinetest")
public class UrineTestController {

    @Autowired
    private UrineTestService service;

    @GetMapping("/getall")
    public String getAll(HttpServletRequest request) {
        setAll(request);
        return "/urineTest/urinetestmanager";
    }

    @GetMapping("/getalluser")
    public String getAllUser(HttpServletRequest request) {
        setAllUser(request);
        return "/urineTest/urinetestmanager";
    }
    @GetMapping("/getalladmin")
    public String getAllAdmin(HttpServletRequest request){
        setAllAdmin(request);
        return "/urineTest/urinetestmanager";
    }

    @GetMapping("/search")
    public String getAllSearch(HttpServletRequest request,@RequestParam("year") String year, @RequestParam("month") String month ) {
        setAllSearch(request, year, month);
        return "/urineTest/urinetestmanager";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        service.delete(id);

        if(user.getUsertype().toString().equals("USER")){
            setAllUser(request);
        } else if (user.getUsertype().toString().equals("ADMIN")){
            setAllAdmin(request);
        } else if (user.getUsertype().toString().equals("SUPER")) {
            setAll(request);
        }
        return "/urineTest/urinetestmanager";
    }
    @GetMapping("/preupdate")
    public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("dto", service.read(id));
        return "/urineTest/updateurinetest";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("color") Float color,
                         @RequestParam("ph") Float ph, @RequestParam("protein") Float protein, @RequestParam("hemoglobin") Float hemoglobin,
                         @RequestParam("idAdmin") Long idAdmin, @RequestParam("idUser") Long idUser, @RequestParam("isChecked") Boolean isChecked,
                         @RequestParam("dateInsert") String dateInsert) {

        UserDTO userSession = (UserDTO) request.getSession().getAttribute("user");
        UrineTestDTO dto = new UrineTestDTO();
        dto.setId(id);
        dto.setColor(color);
        dto.setPh(ph);
        dto.setProtein(protein);
        dto.setHemoglobin(hemoglobin);
        dto.setIdAdmin(idAdmin);
        dto.setIdUser(idUser);
        dto.setIsChecked(isChecked);
        dto.setDateInsert(dateInsert);

        service.update(dto);

        if(userSession.getUsertype().toString().equals("USER")){
            setAllUser(request);
        } else if (userSession.getUsertype().toString().equals("ADMIN")){
            setAllAdmin(request);
        } else if (userSession.getUsertype().toString().equals("SUPER"))
        {
            setAll(request);
        }
        return "/urineTest/urinetestmanager";

    }

    @PostMapping("/insert")
    public String insert(HttpServletRequest request, @RequestParam("color") Float color,
                         @RequestParam("ph") Float ph, @RequestParam("protein") Float protein,
                         @RequestParam("hemoglobin") Float hemoglobin, @RequestParam("idAdmin") Long idAdmin,
                         @RequestParam("idUser") Long idUser, @RequestParam("isChecked") Boolean isChecked,
                         @RequestParam("dateInsert") String dateInsert) {

        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        UrineTestDTO dto = new UrineTestDTO();
        dto.setColor(color);
        dto.setPh(ph);
        dto.setProtein(protein);
        dto.setHemoglobin(hemoglobin);
        dto.setIdAdmin(idAdmin);
        dto.setIdUser(idUser);
        dto.setDateInsert(dateInsert);
        dto.setIsChecked(isChecked);
        service.insert(dto);
        if(user.getUsertype().toString().equals("USER")){
            setAllUser(request);
        } else {
            setAll(request);
        }
        return "/urineTest/urinetestmanager";
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("dto", service.read(id));
        return "/urineTest/readurinetest";
    }

    @PostMapping("/check")
    public String check(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("color") Float color,
                        @RequestParam("ph") Float ph, @RequestParam("protein") Float protein, @RequestParam("hemoglobin") Float hemoglobin,
                        @RequestParam("idAdmin") Long idAdmin, @RequestParam("idUser") Long idUser, @RequestParam("isChecked") Boolean isChecked,
                        @RequestParam("dateInsert") String dateInsert) {

        UserDTO userSession = (UserDTO) request.getSession().getAttribute("user");
        UrineTestDTO dto = new UrineTestDTO();
        dto.setId(id);
        dto.setColor(color);
        dto.setPh(ph);
        dto.setProtein(protein);
        dto.setHemoglobin(hemoglobin);
        dto.setIdAdmin(idAdmin);
        dto.setIdUser(idUser);
        dto.setIsChecked(isChecked);
        dto.setDateInsert(dateInsert);
        service.update(dto);
        if(userSession.getUsertype().toString().equals("ADMIN")){
            setAllAdmin(request);
        } else {
            setAll(request);
        }
        return "/urineTest/urinetestmanager";

    }

    private void setAll(HttpServletRequest request) {
        request.getSession().setAttribute("list", service.getAll());
    }

    private void setAllUser(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findByIdUser(user.getId()));
    }
    private void setAllAdmin(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findByAllIdAdmin(user.getId()));
    }

    private void setAllSearch(HttpServletRequest request, String year, String month) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findAllByYearMonthAndUserId(year, month , user.getId()));
    }

}