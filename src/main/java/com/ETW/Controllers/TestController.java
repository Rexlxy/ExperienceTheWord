package com.ETW.Controllers;

import com.ETW.Beans.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/helloWorld")
    public ResultBean<String> helloWorld() {
        return new ResultBean<>("Hello World");
    }
}
