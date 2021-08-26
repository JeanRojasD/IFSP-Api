package com.br.ifspapi.title;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TitleRepositoryTest {

    @Autowired
    TitleRepository titleRepository;

    @Test
    @Rollback(false)
    public void verifyTitle_WhenHasCreated(){
        TitleForm titleForm = new TitleForm("teste");
        Title titleFinal = titleRepository.save(Title.from(titleForm));

        assertEquals(titleFinal.getTitle(), titleForm.getTitle());
    }

    @Test
    public void verifyListTitles_WhenHasGetAll(){
        List<Title> titleList = titleRepository.findAll();
        List<Title> titleListEmpty = new ArrayList<>();


        assertNotSame(titleList, titleListEmpty);
    }

    @Test
    @Rollback(false)
    public void verifyTitle_WhenHasUpdated(){
        titleRepository.save(new Title("title"));
        TitleForm titleForm = new TitleForm("title updated");
        Long searchId = 1L;

        var modelMapper = new ModelMapper();
        Title titleFound = titleRepository.getById(searchId);

        modelMapper.map(titleForm, titleFound);
        titleRepository.save(titleFound);


        assertEquals(titleForm.getTitle(), titleFound.getTitle());
    }

    @Test
    @Rollback(false)
    public void verifyTitle_WhenHasDeleted(){
        Title title = titleRepository.save(new Title());

        Long id = 1L;

        boolean isExistBeforeDelete = titleRepository.findById(id).isPresent();

        titleRepository.deleteById(id);

        boolean notExistAfterDelete = titleRepository.findById(id).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);
    }

}