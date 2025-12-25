package com.example.demo.service;

import com.example.demo.model.Permission;
import com.example.demo.model.UserModel;
import com.example.demo.rep.PermissionRep;
import com.example.demo.rep.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRep userRep;

    @Autowired
    private PermissionRep permissionRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRep.findByEmail(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(UserModel userModel) {
        UserModel check = userRep.findByEmail(userModel.getEmail());
        if (check == null) {
            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            Permission userRole = permissionRep.findByName("ROLE_USER");
            List<Permission> permissions = new ArrayList<>();
            if (userRole != null) {
                permissions.add(userRole);
            }
            userModel.setPermissions(permissions);
            userRep.save(userModel);
        }
    }
}