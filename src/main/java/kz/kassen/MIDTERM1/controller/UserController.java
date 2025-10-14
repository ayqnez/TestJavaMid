package kz.kassen.MIDTERM1.controller;

import kz.kassen.MIDTERM1.dto.UserDTO;
import kz.kassen.MIDTERM1.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping()
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public UserDTO getById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping()
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }
}
