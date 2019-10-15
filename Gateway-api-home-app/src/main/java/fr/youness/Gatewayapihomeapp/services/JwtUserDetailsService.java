package fr.youness.Gatewayapihomeapp.services;


import fr.youness.Gatewayapihomeapp.beans.UserDto;
import fr.youness.Gatewayapihomeapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fr.youness.Gatewayapihomeapp.beans.User _user = userDao.findByIsActiveAndUsername(true ,username);
        if(_user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(_user.getUsername(), _user.getPassword(), new ArrayList<>());
    }

    public fr.youness.Gatewayapihomeapp.beans.User save(UserDto user) {
        fr.youness.Gatewayapihomeapp.beans.User newUser = new fr.youness.Gatewayapihomeapp.beans.User();
        newUser.setUsername(user.getUsername());
        newUser.setActive(false);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(newUser);
        return newUser;
    }
}