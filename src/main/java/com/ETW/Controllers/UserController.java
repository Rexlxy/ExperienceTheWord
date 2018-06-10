package com.ETW.Controllers;

import com.ETW.Beans.ResultBean;
import com.ETW.Entity.UserEntity;
import com.ETW.Models.User;
import com.ETW.Services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResultBean<List<UserEntity>> getAllUser() {
        List<UserEntity> userEntityList = userService.findAllUses();

        return new ResultBean<>(userEntityList);
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public ResultBean<User> register(User user) {
        if (userService.ifUserExists(user.getUsername())) {
            return new ResultBean(1, "Failed: The username is used");
        } else {
            user = userService.saveUser(user);
            return new ResultBean<>(user);
        }
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public ResultBean<User> getUserInfo(@PathVariable long id) {
        return new ResultBean<User>(userService.getUserById(id));
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public ResultBean<User> updateUser(User user) {
        user = userService.saveUser(user);
        return new ResultBean<>(user);
    }

}
