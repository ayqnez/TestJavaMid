package kz.kassen.MIDTERM1.service.serviceImpl;

import kz.kassen.MIDTERM1.dto.UserDTO;
import kz.kassen.MIDTERM1.mapper.UserMapper;
import kz.kassen.MIDTERM1.repo.UserRepo;
import kz.kassen.MIDTERM1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDtoList(userRepo.findAll());
    }

    @Override
    public UserDTO findById(Long userId) {
        return userMapper.toDto(userRepo.findById(userId).orElse(null));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepo.save(userMapper.toEntity(userDTO));
    }
}
