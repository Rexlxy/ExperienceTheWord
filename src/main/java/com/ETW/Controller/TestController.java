package com.ETW.Controller;

import com.ETW.Bean.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/helloWorld")
    public ResultBean<String> helloWorld() {
        return new ResultBean<>("Hello World");
    }
}
