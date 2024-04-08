package it.contrader.service;

import it.contrader.converter.UrineTestConverter;
import it.contrader.dao.UrineTestRepository;
import it.contrader.dto.UrineTestDTO;
import it.contrader.model.UrineTest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.NamedQuery;
import java.util.List;

@Service
public class UrineTestService extends AbstractService<UrineTest, UrineTestDTO>{
    @Autowired
    private UrineTestConverter converter;
    @Autowired
    private UrineTestRepository repository;

    public List<UrineTestDTO> findByIdUser(Long idUser){
        return converter.toDTOList(repository.findAllByIdUser(idUser));
    }
    public List<UrineTestDTO> findByAllIdAdmin(Long idAdmin){
        return converter.toDTOList(repository.findAllByIdAdmin(idAdmin));
    }

    public List<UrineTestDTO> findAllByYearMonthAndUserId(String year, String month, Long userId){
        return converter.toDTOList(repository.findAllByYearMonthAndUserId(year,  month,  userId) );
    }



}
