package com.ETW.Service;

import com.ETW.DAO.UserRepository;
import com.Util.ConvertUtil;
import com.ETW.Entity.UserEntity;
import com.ETW.Model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {

    @Resource
    UserRepository userRepository;

    public static UserRepository staticUserRepo;

    @PostConstruct
    public void init() {
       staticUserRepo = this.userRepository;
    }

    public List<UserEntity> findAllUses() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        // convert user model into user entity
        UserEntity entity = new UserEntity();
        ConvertUtil.modelToEntity(user, entity);
        // save
        entity = userRepository.save(entity);
        // convert entity back to model
        User model = new User();
        ConvertUtil.entityToModel(entity, model);
        return model;
    }

    public User getUserById(Long id) {
        User model = new User();
        ConvertUtil.entityToModel(userRepository.findById(id).get(), model);
        return model;
    }

    public boolean ifUserExists(String username) {
        if (userRepository.findByUsername(username).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public User login(String username, String password) {
        UserEntity entity = userRepository.findByUsernameAndPassword(username, password);
        if (entity == null) return null;
        User model = new User();
        ConvertUtil.entityToModel(entity, model);
        return model;
    }

}
