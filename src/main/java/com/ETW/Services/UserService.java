package com.ETW.Services;

import com.ETW.DAO.UserDAO;
import com.ETW.Models.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserService {

    @Resource
    UserDAO userDAO;

    public List<User> findAllUses() {
        return userDAO.findAll();
    }

}
