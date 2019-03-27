package com.autentication.controller;

import com.autentication.model.Usuario;
import com.autentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/user")
public class UserCon {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    public List<Usuario> getAll() {
        return userRepo.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    int insertUser(@RequestParam String nome, @RequestParam String cpf, @RequestParam String email, @RequestParam String password) {
        Usuario n = new Usuario(nome, cpf, email, password);
        userRepo.save(n);
        return n.getId();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String deletePessoa(@RequestParam int id) {
        userRepo.deleteById(id);
        return "Deletado" + id;
    }
}
