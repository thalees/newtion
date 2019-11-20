package ftt.app.infra.services;

import ftt.app.domain.model.User;
import ftt.app.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void create(User user){
        try {
            userRepository.saveAndFlush(user);
        } catch (DataIntegrityViolationException ex) {
            throw ex;
        }
    }

    public User find(String nickname, String password){
        return userRepository.findByNicknameAndPassword(nickname, password);
    }
}

