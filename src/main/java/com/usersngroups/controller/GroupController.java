package com.usersngroups.controller;

import com.usersngroups.dto.GroupDTO;
import com.usersngroups.entity.GroupEntity;
import com.usersngroups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/addGroup")
    public ResponseEntity<GroupDTO> saveGroup(@RequestBody GroupDTO groupDTO){
        groupService.saveGroup(groupDTO);

        ResponseEntity<GroupDTO> responseEntity = new ResponseEntity<>(groupDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @PostMapping("/addUsersToGroup")
    public ResponseEntity<GroupDTO> addUsersToGroup(@RequestBody GroupDTO groupDTO){
        groupService.saveUserToGroup(groupDTO);

        ResponseEntity<GroupDTO> responseEntity = new ResponseEntity<>(groupDTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GroupDTO>> getGroups(){
        List<GroupDTO> groupDTOList = groupService.getGroups();
        return new ResponseEntity<>(groupDTOList, HttpStatus.OK);
    }


    @GetMapping("/groups/userid/{userId}")
    public ResponseEntity<List<GroupDTO>> getUsersFromGroup(@PathVariable("userId") Long userId){
        List<GroupDTO> groupDTOList = groupService.getGroups();
        return new ResponseEntity<>(groupDTOList, HttpStatus.OK);
    }


    @PutMapping("/update/{groupId}")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO groupDTO, @PathVariable Long groupId){
        groupDTO = groupService.updateGroup(groupDTO, groupId);

        return new ResponseEntity<>(groupDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{groupId}")
    public void deleteGroup(@PathVariable Long groupId){
        groupService.deleteGroup(groupId);
    }

}
