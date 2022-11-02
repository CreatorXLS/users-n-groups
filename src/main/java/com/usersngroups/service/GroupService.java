package com.usersngroups.service;

import com.usersngroups.dto.GroupDTO;
import com.usersngroups.entity.GroupEntity;

import java.util.List;

public interface GroupService {

    public GroupDTO saveGroup(GroupDTO groupDto);

    public GroupDTO saveUserToGroup(GroupDTO groupDto);

    public List<GroupDTO> getGroups();

    List<GroupDTO> getUsersFromGroup(Long userId);


    public GroupDTO updateGroup(GroupDTO groupDTO, Long groupId);

    public void deleteGroup(Long groupId);

}
