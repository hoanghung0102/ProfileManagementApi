package com.hoanghung.profilemanage.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hxhung on 8/24/2017.
 */
@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "pwd")
    private String password;

    private boolean gender;

    private String address;

    private String city;

    public String toString() {
        return "User [uid=" + id + ", uUserName=" + username + ", uCity=" + city + "]";
    }
}
