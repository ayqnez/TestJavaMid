package kz.kassen.MIDTERM1.service;

import kz.kassen.MIDTERM1.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Long userId);
    void createUser(UserDTO userDTO);
}
