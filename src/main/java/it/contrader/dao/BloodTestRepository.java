package it.contrader.dao;


import javax.transaction.Transactional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;



import it.contrader.model.BloodTest;

import java.util.List;

@Repository
@Transactional
public interface BloodTestRepository extends CrudRepository<BloodTest, Long> {


    List<BloodTest> findAllByIdAdmin(Long idAdmin);

    List<BloodTest> findAllByIdUser(Long idUser);




    @Query("SELECT ut FROM BloodTest ut WHERE SUBSTRING(ut.dateInsert, 1, 4) = :year AND SUBSTRING(ut.dateInsert, 6, 2) = :month AND ut.idUser = :userId")
    List<BloodTest> findAllByYearMonthAndUserId(String year, String month, Long userId);

}
