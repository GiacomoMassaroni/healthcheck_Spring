package it.contrader.converter;

import it.contrader.dto.RegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Registry;
import it.contrader.model.User;
import org.springframework.stereotype.Component;

@Component
public class RegistryConverter extends AbstractConverter<Registry, RegistryDTO> {

	@Override
	public Registry toEntity(RegistryDTO registryDTO) {
		Registry registry = null;
		if (registryDTO != null) {
			registry = new Registry(registryDTO.getId(), registryDTO.getName(), registryDTO.getSurname(), registryDTO.getBirthDate(), registryDTO.getGender(),registryDTO.getNationality(), registryDTO.getCity(), registryDTO.getAddress(), registryDTO.getCf(), registryDTO.getBg(),registryDTO.getIdUser());
		}
		return registry;
	}

	@Override
	public RegistryDTO toDTO(Registry registry) {
		RegistryDTO registryDTO = null;
		if (registry != null) {
			registryDTO = new RegistryDTO(registry.getId(), registry.getName(), registry.getSurname(), registry.getBirthDate(), registry.getGender(),registry.getNationality(), registry.getCity(), registry.getAddress(), registry.getCf(), registry.getBg(),registry.getIdUser());
		}
		return registryDTO;
	}
}