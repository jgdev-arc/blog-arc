package com.tlz.blogarc.service.impl;

import com.tlz.blogarc.dto.RegistrationDTO;
import com.tlz.blogarc.entity.Role;
import com.tlz.blogarc.entity.User;
import com.tlz.blogarc.repository.RoleRepository;
import com.tlz.blogarc.repository.UserRepository;
import com.tlz.blogarc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getFirstName() + " " + registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
