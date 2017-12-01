package com.hoanghung.profilemanage.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hxhung on 8/24/2017.
 */
@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "pcity")
    private String city;

    private String address;

    public String toString() {
        return "Person [pid=" + id + ", pName=" + name + ", pCity=" + city + "]";
    }
}
