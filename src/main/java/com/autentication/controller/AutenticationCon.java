package com.autentication.controller;


import com.autentication.model.Usuario;
import com.autentication.repository.RoleRepo;
import com.autentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/private")
public class AutenticationCon {

    private EntityManager em;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public AutenticationCon(RoleRepo roleRepo, UserRepo userRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<Usuario> getAll() {
        return userRepo.findAll();
    }
}
