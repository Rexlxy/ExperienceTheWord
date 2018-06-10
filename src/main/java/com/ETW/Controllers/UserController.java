package com.ETW.Controllers;

import com.ETW.Beans.ResultBean;
import com.ETW.Models.User;
import com.ETW.Services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/all")
    public ResultBean<List<User>> getAllUser() {
        List<User> userList = userService.findAllUses();

        return new ResultBean<>(userList);
    }
}
