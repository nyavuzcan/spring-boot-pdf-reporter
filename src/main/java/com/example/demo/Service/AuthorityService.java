package com.example.demo.Service;

import com.example.demo.Entity.Authority;
import com.example.demo.Entity.ERole;
import com.example.demo.Repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }

    public Optional<Authority> findByAuthority(ERole authority) {
        return authorityRepository.findByAuthority(authority);
    }

}
