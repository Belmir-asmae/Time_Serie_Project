package com.example.userloginlogout.security;

import com.example.userloginlogout.models.User;
import com.example.userloginlogout.repository.UserRepository;
import com.example.userloginlogout.security.CustomerUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");

        }
        return new CustomerUserDetails(user);
    }
}
