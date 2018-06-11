package com.ETW.Controller;

import com.ETW.Bean.ResultBean;
import com.ETW.Entity.UserEntity;
import com.ETW.Model.User;
import com.ETW.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(name = "/register", method = RequestMethod.POST)
    public ResultBean<User> register(User user) {
        if (userService.ifUserExists(user.getUsername())) {
            return new ResultBean(1, "Failed: username is used");
        } else {
            user = userService.saveUser(user);
            return new ResultBean<>(user);
        }
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public ResultBean<User> getUserInfo(@PathVariable long id, HttpServletRequest request) {
        System.out.println("Current user:" + userService.getUserById((long)request.getSession().getAttribute("curUser")).getUsername());
        return new ResultBean<User>(userService.getUserById(id));
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public ResultBean<User> updateUser(User user) {
        user = userService.saveUser(user);
        return new ResultBean<>(user);
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public ResultBean<User> login(@RequestParam(value = "username", required = true) String username,
                                  @RequestParam(value = "password", required = true) String password,
                                  HttpServletRequest request) {

        // if user not existing
        if (!userService.ifUserExists(username)) {
            return new ResultBean<>(1, "Failed: username doesn't exist");
        }

        User user = userService.login(username, password);
        if (user == null) {
            return new ResultBean<>(1, "Failed: username and password don't match");
        }
        request.getSession().setAttribute("curUser", user.getId());
        return new ResultBean<>(user);
    }
}
