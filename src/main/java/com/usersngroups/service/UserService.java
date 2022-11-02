package com.usersngroups.service;

import com.usersngroups.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers ();

    public UserDTO updateUser(UserDTO userDTO, Long userId);

    void deleteUser(Long userId);
}
