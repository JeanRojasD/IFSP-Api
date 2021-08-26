package com.br.ifspapi.graduation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GraduationTest {

    @Autowired
    private GraduationRepository graduationRepository;

    @Test
    @Rollback(false)
    public void verifyGraduation_WhenHasCreated(){

        GraduationForm graduationForm = new GraduationForm("Robson", "Robson");
        Graduation graduation = graduationRepository.save(Graduation.from(graduationForm));

        assertEquals(graduation.getName(), graduationForm.getName());
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

    @Test
    @Rollback(false)
    public void verifyGraduation_WhenDelete(){
        GraduationForm graduationForm = new GraduationForm("Robson", "Robson");
        Graduation graduation = graduationRepository.save(Graduation.from(graduationForm));

        Long id = 1L;

        boolean present1 = graduationRepository.findById(id).isPresent();

        graduationRepository.deleteById(id);

        boolean present2 = graduationRepository.findById(id).isPresent();

        assertTrue(present1);
        assertFalse(present2);

    }
}
