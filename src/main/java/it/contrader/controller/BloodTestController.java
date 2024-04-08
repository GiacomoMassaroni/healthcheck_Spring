package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import it.contrader.dto.BloodTestDTO;
import it.contrader.dto.UrineTestDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.BloodTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bloodTest")
public class BloodTestController {

    @Autowired
    private BloodTestService service;

    @GetMapping("/getall")
    public String getAll(HttpServletRequest request) {
        setAll(request);
        return "/bloodTest/bloodTest";
    }
    @GetMapping("/getalladmin")
    public String getAllAdmin(HttpServletRequest request) {
        setAllAdmin(request);
        return "/bloodTest/bloodTest";
    }

    @GetMapping("/getalluser")
    public String getAllUser(HttpServletRequest request) {
        setAllUser(request);
        return "/bloodTest/bloodTest";
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
        return "/bloodTest/bloodTest";
    }
    @GetMapping("/preupdate")     public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("dto", service.read(id));
        return "/bloodTest/updateBloodTest";
    }

    @PostMapping("/update")
    public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("redBloodCell") Float redBloodCell, @RequestParam("whiteBloodCell") Float whiteBloodCell, @RequestParam("platelets") Float platelets, @RequestParam("hemoglobin") Float hemoglobin, @RequestParam("idAdmin") Long idAdmin, @RequestParam("idUser") Long idUser, @RequestParam("isChecked") Boolean isChecked, @RequestParam("dateInsert") String dateInsert) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        BloodTestDTO dto = new BloodTestDTO();
        dto.setId(id);
        dto.setRedBloodCell(redBloodCell);
        dto.setWhiteBloodCell(whiteBloodCell);
        dto.setPlatelets(platelets);
        dto.setHemoglobin(hemoglobin);
        dto.setIdAdmin(idAdmin);
        dto.setIdUser(idUser);
        dto.setIsChecked(isChecked);
        dto.setDateInsert(dateInsert);

        service.update(dto);
        
        if(user.getUsertype().toString().equals("USER")){
            setAllUser(request);
       } else if(user.getUsertype().toString().equals("ADMIN")) {
            setAllAdmin(request);
        } else {
            setAll(request);
        }
        return "/bloodTest/bloodTest";

    }
    @PostMapping("/check")
    public String check(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("redBloodCell") Float redBloodCell, @RequestParam("whiteBloodCell") Float whiteBloodCell, @RequestParam("platelets") Float platelets, @RequestParam("hemoglobin") Float hemoglobin, @RequestParam("idAdmin") Long idAdmin, @RequestParam("idUser") Long idUser, @RequestParam("isChecked") Boolean isChecked, @RequestParam("dateInsert") String dateInsert) {
        UserDTO userSession = (UserDTO) request.getSession().getAttribute("user");
        BloodTestDTO dto = new BloodTestDTO();
        dto.setId(id);
        dto.setRedBloodCell(redBloodCell);
        dto.setWhiteBloodCell(whiteBloodCell);
        dto.setPlatelets(platelets);
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
        return "/bloodTest/bloodTest";

    }

    @PostMapping("/insert")
    public String update(HttpServletRequest request,
                         @RequestParam("redBloodCell") Float redBloodCell, @RequestParam("whiteBloodCell") Float whiteBloodCell,
                         @RequestParam("platelets") Float platelets, @RequestParam("hemoglobin") Float hemoglobin,
                         @RequestParam("idAdmin") Long idAdmin, @RequestParam("idUser") Long idUser,
                         @RequestParam("isChecked") Boolean isChecked, @RequestParam("dateInsert") String dateInsert)  {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        BloodTestDTO dto = new BloodTestDTO();
        dto.setRedBloodCell(redBloodCell);
        dto.setWhiteBloodCell(whiteBloodCell);
        dto.setPlatelets(platelets);
        dto.setHemoglobin(hemoglobin);
        dto.setIdAdmin(idAdmin);
        dto.setIdUser(idUser);
        dto.setIsChecked(isChecked);
        dto.setDateInsert(dateInsert);
        service.insert(dto);
        if(user.getUsertype().toString().equals("USER")){
            setAllUser(request);
        } else {
            setAll(request);
        }

        return "/bloodTest/bloodTest";
    }

    @GetMapping("/read")
    public String read(HttpServletRequest request, @RequestParam("id") Long id) {
        request.getSession().setAttribute("dto", service.read(id));
        return "/bloodTest/readBloodTest";
    }

    @GetMapping("/search")
    public String getAllSearch(HttpServletRequest request,@RequestParam("year") String year, @RequestParam("month") String month ) {
        setAllSearch(request, year, month);
        return "/bloodTest/bloodTest";
    }


    private void setAll(HttpServletRequest request) {request.getSession().setAttribute("list", service.getAll());}


    private void setAllAdmin(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findByIdAdmin(user.getId()));
    }
    
    private void setAllUser(HttpServletRequest request) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findByIdUser(user.getId()));
    }


    private void setAllSearch(HttpServletRequest request, String year, String month) {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        request.getSession().setAttribute("list", service.findAllByYearMonthAndUserId(year, month , user.getId()));
    }

}
