package com.autentication.repository;

import com.autentication.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Roles, Integer> {
}
