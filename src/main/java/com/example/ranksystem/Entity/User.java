package com.example.ranksystem.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {

    public User(){

    }
    public User(String id, String password, String name, Boolean permission){
        this.id = id;
        this.password = password;
        this.name = name;
        this.permission = permission;
    }

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "name", length = 10)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    @Column(name = "permission")
    private Boolean permission;

}
