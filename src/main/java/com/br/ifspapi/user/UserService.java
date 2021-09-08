package com.br.ifspapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDTO::from).collect(Collectors.toList());
    }

    public UserDTO findById(Long id){
        return UserDTO.from(userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }));
    }

    public UserDTO create(UserForm userForm){
        return UserDTO.from(userRepository.save(User.from(userForm)));
    }

    public UserDTO update(Long id, UserForm userForm){

        User userFound = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        return UserDTO.from(userRepository.save(userFound));
    }

    public void delete(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        userRepository.delete(user);
    }
}
