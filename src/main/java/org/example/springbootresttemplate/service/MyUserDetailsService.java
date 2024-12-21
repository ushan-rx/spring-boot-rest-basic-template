package org.example.springbootresttemplate.service;


import org.example.springbootresttemplate.model.User;
import org.example.springbootresttemplate.model.UserPrincipal;
import org.example.springbootresttemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            System.out.println("user 404");
            throw new UsernameNotFoundException("user 404");
        }
        return new UserPrincipal(user);
    }
}
