package com.mukho.ranksystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "permission", length = 5)
    private String permission = "false";

}
