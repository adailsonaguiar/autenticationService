package com.autentication.controller;

import com.autentication.model.Roles;
import com.autentication.model.Usuario;
import com.autentication.repository.RoleRepo;
import com.autentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/user")
public class UserCon {

    private EntityManager em;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserCon(RoleRepo roleRepo, UserRepo userRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public List<Usuario> getAll() {
        return userRepo.findAll();
    }

    @PostMapping(path = "/add")
    public ResponseEntity insertUser(@RequestParam String nome, @RequestParam String cpf, @RequestParam String email, @RequestParam String password) {
        try{
            Usuario n = new Usuario(nome, cpf, email, password, true);
            userRepo.save(n);
            Roles r = new Roles(n.getUsername(),"ADMIN");
            roleRepo.save(r);
            return ResponseEntity.ok().body(n);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Falha ao salvar usuário, verifique os logs!");
        }
    }

    @PostMapping(path = "login")
    public ResponseEntity login(@RequestParam String user, @RequestParam String password) {
        if (user.equals("adailsonacj") && password.equals("123")) {
            return ResponseEntity.ok().body("usuário autorizado!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("usuário sem permissão!");
    }

//    @PostMapping(path = "login")
//    public Response login(@Context HttpHeaders httpHeaders, @RequestParam String user, @RequestParam String password) {
//
//        Autenticator autenticator = Autenticator.getInstance();
//        String serviceKey = httpHeaders.getHeaderString(Headers.KEY);
//        try {
//            String authToken = autenticator.login(user, password, serviceKey);
//            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//            jsonObjBuilder.add("token", authToken);
//            JsonObject jsonObj = jsonObjBuilder.build();
//            return Response.ok(jsonObj.toString()).build();
//
//        } catch (final LoginException ex) {
//            JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
//            jsonObjBuilder.add("message", "Problem matching key, user and password");
//            JsonObject jsonObj = jsonObjBuilder.build();
//
//            return Response
//                    .status(Status.UNAUTHORIZED)
//                    .entity(jsonObj.toString())
//                    .build();
//        }
//    }
}
