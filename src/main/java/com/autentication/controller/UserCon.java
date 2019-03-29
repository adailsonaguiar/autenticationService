package com.autentication.controller;

import com.autentication.model.Usuario;
import com.autentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    int insertUser(@RequestBody Usuario usuario) {
        Usuario n = usuario;
        userRepo.save(n);
        return n.getId();
    }

    @PostMapping(path = "login")
    public ResponseEntity login(@RequestParam String user, @RequestParam String password) {
        if (user.equals("adailsonacj") && password.equals("123")) {
            return ResponseEntity.ok().body("usuário autorizado!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("usuário sem permissão!");
    }

    @GetMapping(path = "tras")
    public ResponseEntity tras() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("unauthorized");
    }

    @GetMapping(path = "usuario")
    public Usuario usuario() {
        Usuario u = new Usuario("BIBI", "02348203498", "bibi@gmail.com", "123");
        return u;
    }
}
