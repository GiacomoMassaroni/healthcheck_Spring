package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.BloodTestConverter;
import it.contrader.dao.BloodTestRepository;
import it.contrader.dto.BloodTestDTO;
import it.contrader.dto.UrineTestDTO;
import it.contrader.model.BloodTest;

import java.util.List;

import java.util.List;

import java.util.List;

@Service
public class BloodTestService extends AbstractService<BloodTest, BloodTestDTO> {

    @Autowired
    private BloodTestConverter converter;
    @Autowired
    private BloodTestRepository repository;
    public List<BloodTestDTO> findByIdAdmin(Long idAdmin){
        return converter.toDTOList(repository.findAllByIdAdmin(idAdmin));
    }

    public List<BloodTestDTO> findByIdUser(Long idUser) {
        return converter.toDTOList(repository.findAllByIdUser(idUser));
    }

    public List<BloodTestDTO> findAllByYearMonthAndUserId(String year, String month, Long userId){
        return converter.toDTOList(repository.findAllByYearMonthAndUserId(year,  month,  userId) );
    }

 }
