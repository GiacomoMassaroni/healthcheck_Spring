package it.contrader.converter;

import it.contrader.dto.BloodTestDTO;

import it.contrader.model.BloodTest;

import org.springframework.stereotype.Component;

@Component
public class BloodTestConverter extends AbstractConverter<BloodTest, BloodTestDTO> {

	@Override
	public BloodTest toEntity(BloodTestDTO bloodTestDTO) {
		BloodTest test = null;
		if (bloodTestDTO != null) {
			test = new BloodTest(bloodTestDTO.getId(), bloodTestDTO.getRedBloodCell(), bloodTestDTO.getWhiteBloodCell(), bloodTestDTO.getPlatelets(), bloodTestDTO.getHemoglobin(), bloodTestDTO.getIdAdmin(), bloodTestDTO.getIdUser() ,bloodTestDTO.getIsChecked(), bloodTestDTO.getDateInsert());
		}
		return test;
	}

	@Override
	public BloodTestDTO toDTO(BloodTest bloodTest) {
		BloodTestDTO bloodTestDTO = null;
		if (bloodTest != null) {
			bloodTestDTO = new BloodTestDTO(bloodTest.getId(), bloodTest.getRedBloodCell(), bloodTest.getWhiteBloodCell(), bloodTest.getPlatelets(), bloodTest.getHemoglobin(), bloodTest.getIdAdmin(), bloodTest.getIdUser() ,bloodTest.getIsChecked(), bloodTest.getDateInsert());

		}
		return bloodTestDTO;
	}
}