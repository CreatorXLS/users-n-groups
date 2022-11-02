package com.usersngroups.converter;

import com.usersngroups.dto.GroupDTO;
import com.usersngroups.dto.UserDTO;
import com.usersngroups.entity.GroupEntity;
import com.usersngroups.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserCoverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUserName(userDTO.getUserName());
        return userEntity;
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        return userDTO;
    }
}
