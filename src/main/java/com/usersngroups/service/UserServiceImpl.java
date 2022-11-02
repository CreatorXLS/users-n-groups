package com.usersngroups.service;

import com.usersngroups.converter.UserCoverter;
import com.usersngroups.dto.GroupDTO;
import com.usersngroups.dto.UserDTO;
import com.usersngroups.entity.GroupEntity;
import com.usersngroups.entity.UserEntity;
import com.usersngroups.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCoverter userCoverter;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userCoverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        UserDTO dto = userCoverter.convertEntityToDTO(userEntity);

        return dto;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : userEntityList){
            UserDTO userDTO = userCoverter.convertEntityToDTO(userEntity);
            userDTOList.add(userDTO);

        }
        return userDTOList;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        UserDTO userDTO1 = null;
        if(userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            userEntity.setUserName(userDTO.getUserName());
            userDTO1 = userCoverter.convertEntityToDTO(userEntity);
            userRepository.save(userEntity);
        }
        return userDTO1;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
