package com.br.ifspapi.user;

import com.br.ifspapi.commons.Affiliation;
import com.br.ifspapi.commons.Roles;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(false)
    public void verifyUser_WhenHasCreated() {

        UserForm userForm = new UserForm("https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg", "Rodrigo Severo", "Severo", "rodrigosevero@email.com",
                LocalDate.of(2020, 12, 10), 21310201, LocalDate.of(2020, 12, 10), LocalDate.now(), Roles.DEFAULT , Affiliation.EGRESSO );

        User userFinal = userRepository.save(User.from(userForm));

        assertEquals(userFinal.getRa(), userForm.getRa());
    }

    @Test
    void verifyUser_WhenHasUpdated() {
        UserForm userSaveForm = new UserForm("https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg", "Rodrigo Severo", "Severo", "rodrigosevero@email.com",
                LocalDate.of(2020, 12, 10), 21310201, LocalDate.of(2020, 12, 10), LocalDate.now(), Roles.DEFAULT , Affiliation.EGRESSO );

        userRepository.save(User.from(userSaveForm));

        UserForm userForm= new UserForm("https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg", "Rodrigo Severo Editado", "Severo", "rodrigosevero@email.com",
                 LocalDate.of(2020, 12, 10), 21310201, LocalDate.of(2020, 12, 10), LocalDate.now(), Roles.DEFAULT , Affiliation.EGRESSO );

        Long searchId = 1L;

        var modelMapper = new ModelMapper();
        User userFound = userRepository.getById(searchId);

        modelMapper.map(userForm, userFound);
        User userFinal = userRepository.save(userFound);

        assertEquals(userForm.getName(), userFinal.getName());

    }

    @Test
    void verifyUser_WhenHasDeleted() {

        UserForm userSaveForm = new UserForm("https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg", "Rodrigo Severo", "Severo", "rodrigosevero@email.com",
                LocalDate.of(2020, 12, 10), 21310201, LocalDate.of(2020, 12, 10), LocalDate.now(), Roles.DEFAULT , Affiliation.EGRESSO );

        userRepository.save(User.from(userSaveForm));

        Long id = 1L;

        boolean isExistBeforeDelete = userRepository.findById(id).isPresent();

        userRepository.deleteById(id);

        boolean notExistAfterDelete = userRepository.findById(id).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);

    }
}