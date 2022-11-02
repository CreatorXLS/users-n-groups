package com.usersngroups.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUP_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class GroupEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

}
