package it.contrader.dao;

import it.contrader.model.Registry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistryRepository extends CrudRepository<Registry, Long> {


}
