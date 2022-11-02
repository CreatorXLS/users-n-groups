package com.usersngroups.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDTO {

    private Long id;
    private String groupName;

    private Long userId;

}
