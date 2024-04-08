package it.contrader.converter;

import it.contrader.dto.UrineTestDTO;
import it.contrader.model.UrineTest;
import org.springframework.stereotype.Component;

@Component
public class UrineTestConverter extends AbstractConverter<UrineTest, UrineTestDTO>{
    @Override
    public UrineTest toEntity(UrineTestDTO urineTestDTO) {
        UrineTest urineTest = null;
        if (urineTestDTO != null) {
            urineTest = new UrineTest(urineTestDTO.getId(), urineTestDTO.getColor(),urineTestDTO.getPh(),urineTestDTO.getProtein(), urineTestDTO.getHemoglobin(),urineTestDTO.getIdAdmin(),urineTestDTO.getDoctorName(),urineTestDTO.getIdUser(),urineTestDTO.getIsChecked(),urineTestDTO.getDateInsert());
        }
        return urineTest;
    }

    @Override
    public UrineTestDTO toDTO(UrineTest urineTest) {
        UrineTestDTO urineTestDTO = null;
        if (urineTest != null) {
            urineTestDTO = new UrineTestDTO(urineTest.getId(), urineTest.getColor(),urineTest.getPh(),urineTest.getProtein(), urineTest.getHemoglobin(),urineTest.getIdAdmin(),urineTest.getDoctorName(), urineTest.getIdUser(),urineTest.getIsChecked(),urineTest.getDateInsert());

        }
        return urineTestDTO;
    }
}