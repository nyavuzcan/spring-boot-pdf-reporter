package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private ERole authority;

    public Authority() {
    }

    public Authority(ERole authority) {
        this.id = id;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getAuthority() {
        return authority;
    }

    public void setAuthority(ERole authority) {
        this.authority = authority;
    }
}
