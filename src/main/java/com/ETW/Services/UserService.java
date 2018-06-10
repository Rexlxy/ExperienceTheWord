package com.ETW.Services;

import com.ETW.DAO.UserRepository;
import com.ETW.Models.User;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {

    @Resource
    UserRepository userRepository;

    public List<User> findAllUses() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public boolean ifUserExists(String username) {
        if (userRepository.findByUsername(username).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
