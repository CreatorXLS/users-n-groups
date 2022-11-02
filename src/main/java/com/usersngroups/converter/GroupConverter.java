package com.usersngroups.converter;

import com.usersngroups.dto.GroupDTO;
import com.usersngroups.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {

    public GroupEntity convertDTOtoEntity(GroupDTO groupDTO){
        GroupEntity groupEntity = new GroupEntity();
//        groupEntity.setId(groupDTO.getId());
        groupEntity.setGroupName(groupDTO.getGroupName());
//        groupEntity.setUser(groupDto.getUser());
        return groupEntity;
    }

    public GroupDTO convertEntityToDTO(GroupEntity groupEntity){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(groupEntity.getId()); 
        groupDTO.setGroupName(groupEntity.getGroupName());
//        groupDTO.setUser(groupEntity.getUser());
        return groupDTO;
    }

}
