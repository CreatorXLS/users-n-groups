package com.usersngroups.controller;

import com.usersngroups.dto.GroupDTO;
import com.usersngroups.dto.UserDTO;
import com.usersngroups.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveGroup(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);

        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getGroups(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> updateGroup(@RequestBody UserDTO userDTO, @PathVariable Long userId){
        userDTO = userService.updateUser(userDTO, userId);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteGroup(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
