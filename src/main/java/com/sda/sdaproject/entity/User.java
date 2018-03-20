package com.sda.sdaproject.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
