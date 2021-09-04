package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = authService.findByUserName(userName);
        if (user.isPresent()) {

        } else {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getAuthority().getAuthority().name()));
        	
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(),authorities);
        		
    }
}
