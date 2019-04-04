package com.autentication.controller;

import com.autentication.model.Usuario;
import com.autentication.repository.RoleRepo;
import com.autentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/rest/public")
public class UserCon {

    private EntityManager em;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserCon(RoleRepo roleRepo, UserRepo userRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @PostMapping(path = "/add")
    public ResponseEntity insertUser(@RequestParam(value = "nome") String nome, @RequestParam(value = "cpf") String cpf, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        try {
            Usuario n = new Usuario(nome, cpf, email, password, true);
            userRepo.save(n);
            return ResponseEntity.ok().body(n);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Falha ao salvar usuário, verifique os logs!");
        }
    }
}
