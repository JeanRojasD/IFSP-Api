package com.br.ifspapi.anexo;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnexoTest {

    @Autowired
    AnexoRepository anexoRepository;

    @Test
    @Rollback(false)
    public void verifySrcHasCreated_Anexo(){
        AnexoForm anexoForm = new AnexoForm("Imagem.png");
        AnexoModel anexoModel = anexoRepository.save(AnexoModel.from(anexoForm));
        assertEquals(anexoModel.getSrc(), anexoForm.getSrc());
    }

    @Test
    @Rollback(false)
    public void verifySrcHasUpdated_Anexo(){
        anexoRepository.save(new AnexoModel("Imagem.png"));
        AnexoForm anexoForm = new AnexoForm("OutraImagem.png");
        Long searchId = 1L;
        ModelMapper modelMapper = new ModelMapper();
        AnexoModel anexoModel = anexoRepository.getById(searchId);
        modelMapper.map(anexoForm, anexoModel);
        anexoRepository.save(anexoModel);
        assertEquals(anexoForm.getSrc(), anexoModel.getSrc());
    }

    @Test
    @Rollback(false)
    public void verifySrcHasDeleted_Anexo(){
        AnexoModel saveRepository = anexoRepository.save(new AnexoModel());
        Long id = 1L;
        boolean existYes = anexoRepository.findById(id).isPresent();
        anexoRepository.deleteById(id);
        boolean existNo = anexoRepository.findById(id).isPresent();
        assertTrue(existYes);
        assertFalse(existNo);
    }


}
