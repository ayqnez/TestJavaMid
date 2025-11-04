package kz.kassen.MIDTERM1;

import kz.kassen.MIDTERM1.dto.UserDTO;
import kz.kassen.MIDTERM1.entity.User;
import kz.kassen.MIDTERM1.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void convertToDto() {
        User user = new User(1L, "Ayan");
        UserDTO userDTO = userMapper.toDto(user);

        Assertions.assertNotNull(userDTO);
        Assertions.assertNotNull(userDTO.getId());
        Assertions.assertNotNull(userDTO.getNameDTO());

        Assertions.assertEquals(user.getId(), userDTO.getId());
        Assertions.assertEquals(user.getName(), userDTO.getNameDTO());
    }

    @Test
    void convertToEntity() {
        UserDTO userDTO = new UserDTO(1L, "Amir");
        User user = userMapper.toEntity(userDTO);

        Assertions.assertNotNull(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertNotNull(user.getName());

        Assertions.assertEquals(userDTO.getId(), user.getId());
        Assertions.assertEquals(userDTO.getNameDTO(), user.getName());
    }

    @Test
    void convertToDtoList() {
        List<User> usersList = new ArrayList<>();
        List<User> usersListTest = new ArrayList<>();

        usersList.add(new User(1L, "Arsen"));
        usersList.add(new User(2L, "Vasya"));

        List<UserDTO> userDTOsList = userMapper.toDtoList(usersList);

        Assertions.assertNotNull(userDTOsList);
        Assertions.assertEquals(usersList.size(), userDTOsList.size());

        for (User user : usersList) {
            UserDTO userDTO = userMapper.toDto(user);

            Assertions.assertNotNull(user);
            Assertions.assertNotNull(userDTO);

            Assertions.assertEquals(user.getId(), userDTO.getId());
            Assertions.assertEquals(user.getName(), userDTO.getNameDTO());
        }
    }
}
