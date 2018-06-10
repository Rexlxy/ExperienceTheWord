package com.ETW.Controllers;

import com.ETW.Beans.ResultBean;
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
    public ResultBean<List<User>> getAllUser() {
        List<User> userList = userService.findAllUses();

        return new ResultBean<>(userList);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultBean<User> register(User user) {
        if (userService.ifUserExists(user.getUsername())) {
            return new ResultBean(1, "Failed: The username is used");
        } else {
            User newUser = userService.createUser(user);
            return new ResultBean<>(newUser);
        }
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public ResultBean<User> getUserInfo(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        User user = userService.getUserById(userId);
        user.setPassword("");
        return new ResultBean<>(user);
    }
}
