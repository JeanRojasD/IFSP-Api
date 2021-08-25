package com.br.ifspapi;

import com.br.ifspapi.graduation.controller.GraduationController;
import com.br.ifspapi.graduation.dto.GraduationForm;
import com.br.ifspapi.graduation.model.Graduation;
import com.br.ifspapi.graduation.repository.GraduationRepository;
import com.br.ifspapi.graduation.service.GraduationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IfspApiApplicationTests {

    @Autowired
    private GraduationController graduationController;

    @Autowired
    private GraduationRepository graduationRepository;

    @MockBean
    private GraduationService graduationService;


    @Test
    @Rollback(false)
    public void verifyGraduation_WhenHasCreated(){

        GraduationForm graduationForm = new GraduationForm("Robson", "Robson");
        Graduation graduation = graduationRepository.save(Graduation.from(graduationForm));

        assertEquals(graduation.getName(), graduationForm.getName());
    }

    @Test
    public void testFindGraduationByName(){
        String name = "Robson";
        Graduation graduation = graduationRepository.findByName(name);

        assertThat(graduation.getName()).isEqualTo(name);


    }
    @Test
    @Rollback(false)
    public void testUpdateGraduation(){
        String name = "Rafael";

        Graduation graduation = new Graduation(name, "sim");
        graduation.setId(1L);

        graduationRepository.save(graduation);

        Graduation updateGraduation = graduationRepository.findByName(name);

        assertThat(updateGraduation.getName()).isEqualTo(name);
    }

//    @Test
//    public void testListGraduation(){
//        GraduationForm graduationForm = new GraduationForm("Robson", "Robson");
//
//        List<Graduation> graduations = (List<Graduation>) graduationRepository.findAll();
//
//        assertThat(graduations).size().isGreaterThan(0);
//    }


    @Test
    @Rollback(false)
    public void verifyGraduation_WhenDelete(){
        Long id = 1L;

        boolean present1 = graduationRepository.findById(id).isPresent();

        graduationRepository.deleteById(id);

        boolean present2 = graduationRepository.findById(id).isPresent();

        assertTrue(present1);
        assertFalse(present2);

    }
}
