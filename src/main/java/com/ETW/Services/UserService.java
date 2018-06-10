package com.ETW.Services;

import com.ETW.DAO.UserRepository;
import com.ETW.DateUtil;
import com.ETW.Entity.UserEntity;
import com.ETW.Models.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {

    @Resource
    UserRepository userRepository;

    public List<UserEntity> findAllUses() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        // convert user model into user entity
        UserEntity entity = new UserEntity();
        UserService.modelToEntity(user, entity);
        // save
        entity = userRepository.save(entity);
        // convert entity back to model
        User model = new User();
        UserService.entityToModel(entity, model);
        return model;
    }

    public User getUserById(Long id) {
        User model = new User();
        UserService.entityToModel(userRepository.findById(id).get(), model);
        return model;
    }


    public boolean ifUserExists(String username) {
        if (userRepository.findByUsername(username).size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void modelToEntity(User model, UserEntity entity) {

        if (model.getId() != 0) {
            entity.setId(model.getId());
        }
        if (model.getPassword() != null) {
            entity.setPassword(model.getPassword());
        }

        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setUsername(model.getUsername());
        entity.setImage(model.getImage());

    }

    public static void entityToModel(UserEntity entity, User model) {
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setImage(entity.getImage());

        // set dates
        if (entity.getDateCreated() != null) {
            long dateCreated = entity.getDateCreated().getTime();
            model.setDateCreated(DateUtil.millisToString(dateCreated));
        } else {
            model.setDateCreated("");
        }

        if (entity.getDateModified() != null) {
            long dateModified = entity.getDateModified().getTime();
            model.setDateModified(DateUtil.millisToString(dateModified));
        } else {
            model.setDateModified("");
        }


    }
}
