package com.api.mappers;

import com.api.domain.User;
import com.api.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDto (UserDTO userDTO);

    UserDTO toDto(User user);
}
