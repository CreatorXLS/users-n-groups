package com.usersngroups.repository;

import com.usersngroups.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GroupRepository extends JpaRepository<GroupEntity, Long> {


}
