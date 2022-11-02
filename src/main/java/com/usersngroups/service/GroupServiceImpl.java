package com.usersngroups.service;

import com.usersngroups.converter.GroupConverter;
import com.usersngroups.dto.GroupDTO;
import com.usersngroups.entity.GroupEntity;
import com.usersngroups.entity.UserEntity;
import com.usersngroups.repository.GroupRepository;
import com.usersngroups.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupConverter groupConverter;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public GroupDTO saveGroup(GroupDTO groupDto) {

            GroupEntity groupEntity = groupConverter.convertDTOtoEntity(groupDto);
            groupEntity =  groupRepository.save(groupEntity);
            groupDto = groupConverter.convertEntityToDTO(groupEntity);

        return groupDto;
    }

    @Override
    public GroupDTO saveUserToGroup(GroupDTO groupDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(groupDto.getUserId());
        if(optionalUserEntity.isPresent()){
            GroupEntity groupEntity = groupConverter.convertDTOtoEntity(groupDto);
            groupEntity.setUser(optionalUserEntity.get());
            groupEntity =  groupRepository.save(groupEntity);
            groupDto = groupConverter.convertEntityToDTO(groupEntity);
        }

        return groupDto;
    }

    @Override
    public List<GroupDTO> getGroups() {
        List<GroupEntity> groupEntityList = groupRepository.findAll();
        List<GroupDTO> groupDTOList = new ArrayList<>();
        for(GroupEntity groupEntity : groupEntityList){
            GroupDTO groupDTO = groupConverter.convertEntityToDTO(groupEntity);
            groupDTOList.add(groupDTO);

        }
        return groupDTOList;
    }

    @Override
    public List<GroupDTO> getUsersFromGroup(Long userId) {
        List<GroupEntity> groupEntityList = groupRepository.findAll();
        List<GroupDTO> groupDTOList = new ArrayList<>();
        for(GroupEntity groupEntity : groupEntityList){
            GroupDTO groupDTO = groupConverter.convertEntityToDTO(groupEntity);
            groupDTOList.add(groupDTO);

        }
        return groupDTOList;
    }

//    @Override
//    public List<GroupEntity> findAllByGroupName() {
//        return groupRepository.findAllByGroupName();
//    }

    @Override
    public GroupDTO updateGroup(GroupDTO groupDTO, Long groupId) {
        Optional<GroupEntity> groupEntityOptional = groupRepository.findById(groupId);
        GroupDTO groupDTO1 = null;
        if(groupEntityOptional.isPresent()){
            GroupEntity groupEntity = groupEntityOptional.get();
            groupEntity.setGroupName(groupDTO.getGroupName());
            groupDTO1 = groupConverter.convertEntityToDTO(groupEntity);
            groupRepository.save(groupEntity);
        }
        return groupDTO1;
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
