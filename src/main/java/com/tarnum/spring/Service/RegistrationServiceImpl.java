package com.tarnum.spring.Service;

import com.tarnum.spring.Dto.RegistrationUserDTO;
import com.tarnum.spring.Dao.IdeasDAO;
import com.tarnum.spring.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private IdeasDAO dao;

    @Override
    public boolean isUserExists(String login) {
        return dao.isUserExists(login);
    }

    @Override
    public RegistrationStatus register(RegistrationUserDTO dto) {
        try {
            User user = new User();
            user.setEmail(dto.getLogin());
            String salt;
            salt = generateSalt(20);
            user.setSalt(salt);
            String hash = hash(salt + dto.getPassword());
            user.setPassword(hash);
            boolean result = dao.registerUser(user);
            if (result) {
                return RegistrationStatus.OK;
            }
            return RegistrationStatus.DB_ERROR;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return RegistrationStatus.SERVER_ERROR;
        }
    }

    private String hash(String fullPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(fullPassword.getBytes());
        byte[] result = digest.digest();
        return DatatypeConverter.printBase64Binary(result);
    }

    private String generateSalt(int length) throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[length];
        random.nextBytes(salt);
        return DatatypeConverter.printBase64Binary(salt);
    }
}
