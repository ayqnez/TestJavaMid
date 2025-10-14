package kz.kassen.MIDTERM1.mapper;

import kz.kassen.MIDTERM1.dto.UserDTO;
import kz.kassen.MIDTERM1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name", target = "nameDTO")
    UserDTO toDto(User user);

    @Mapping(source = "nameDTO", target = "name")
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> users);
}
