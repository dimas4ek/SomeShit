package com.dimas4ek.YoMaYo.service;

import com.dimas4ek.YoMaYo.domain.Role;
import com.dimas4ek.YoMaYo.domain.User;
import com.dimas4ek.YoMaYo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s.\n" +
                            "Please, visit http://localhost:8080/activate/%s to confirm your account",
                    user.getUsername(), user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Activation Code", message);
        }

        userRepo.save(user);

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if(user == null) {
            return false;
        }

        user.setActivationCode(null);

        user.setActive(true);

        userRepo.save(user);

        return true;
    }
}
