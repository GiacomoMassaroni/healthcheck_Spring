package it.contrader.service;

import it.contrader.converter.RegistryConverter;
import it.contrader.dao.RegistryRepository;
import it.contrader.dto.BloodTestDTO;
import it.contrader.dto.RegistryDTO;
import it.contrader.model.Registry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistryService extends AbstractService<Registry, RegistryDTO> {

	@Autowired
	private RegistryConverter converter;
	@Autowired
	private RegistryRepository repository;

}
