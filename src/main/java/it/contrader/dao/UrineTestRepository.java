package it.contrader.dao;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;

import it.contrader.dto.UrineTestDTO;
import it.contrader.model.UrineTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

import java.util.List;

@Repository
@Transactional
public interface UrineTestRepository extends CrudRepository<UrineTest, Long> {

    @Query("SELECT urinetest.ut, t1_1.surname as patienceSurname, t1_1.name as patienceName, t1_2.surname as doctorSurname, t1_2.name doctorName FROM urinetest join registry t1_1 on urinetest.idUser = t1_1.id  join registry t1_2 on urinetest.idAdmin = t1_2.id;")
    List<UrineTest> findAllByIdUser(Long idUser);
    List<UrineTest> findAllByIdAdmin(Long idAdmin);

    @Query("SELECT ut FROM UrineTest ut WHERE SUBSTRING(ut.dateInsert, 1, 4) = :year AND SUBSTRING(ut.dateInsert, 6, 2) = :month AND ut.idUser = :userId")
    List<UrineTest> findAllByYearMonthAndUserId(String year, String month, Long userId);

}
