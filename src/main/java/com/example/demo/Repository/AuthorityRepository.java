package com.example.demo.Repository;

import com.example.demo.Entity.Authority;
import com.example.demo.Entity.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
   Optional<Authority> findByAuthority(ERole authority);
}
