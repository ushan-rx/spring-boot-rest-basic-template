package org.example.springbootresttemplate.service;


import org.example.springbootresttemplate.model.User;
import org.example.springbootresttemplate.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUSer(User user){
//        encrypt password using bcrypt
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }

}
