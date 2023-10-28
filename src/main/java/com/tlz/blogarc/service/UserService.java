package com.tlz.blogarc.service;

import com.tlz.blogarc.dto.RegistrationDTO;
import com.tlz.blogarc.entity.User;

public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);

    User findByEmail(String email);
}
