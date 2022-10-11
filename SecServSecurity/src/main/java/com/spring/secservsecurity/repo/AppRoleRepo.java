package com.spring.secservsecurity.repo;

import com.spring.secservsecurity.Entity.AppRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);

}
