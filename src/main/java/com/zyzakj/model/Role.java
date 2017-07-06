package com.zyzakj.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by zyzakj on 2017-06-26.
 */
@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;

    @Column(name="role")
    private String role;

    /*
    @ManyToMany(mappedBy = "roles")
    private Set<User> roles;
    */
}
