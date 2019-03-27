package com.autentication.repository;

import com.autentication.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Usuario, Integer> {
}
