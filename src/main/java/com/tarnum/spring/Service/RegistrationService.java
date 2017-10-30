package com.tarnum.spring.Service;

import com.tarnum.spring.Dto.RegistrationUserDTO;

public interface RegistrationService {

    boolean isUserExists(String login);

    enum RegistrationStatus {
        OK, VALIDATION_ERROR, DUPLICATE, DB_ERROR, SERVER_ERROR
    }

    RegistrationStatus register(RegistrationUserDTO dto);
}
