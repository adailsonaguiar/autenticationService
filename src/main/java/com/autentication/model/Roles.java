package com.autentication.model;

import javax.persistence.*;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id;
    //    @MapsId("id_pessoa")
//    @OneToOne
//    @JoinColumn(name = "id_pessoa")
//    private Usuario idusuario;
    private String username;
    private String role;

//    public Roles(Usuario idusuario, String role) {
//        this.idusuario = idusuario;
//        this.role = role;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Roles(String username, String role) {
        this.username = username;
        this.role = role;
    }
}
