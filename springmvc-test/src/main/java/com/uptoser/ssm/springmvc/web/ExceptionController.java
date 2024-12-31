package com.uptoser.ssm.springmvc.web;

import com.uptoser.ssm.springmvc.exception.RoleException;
import com.uptoser.ssm.springmvc.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("exception")
public class ExceptionController {

    /**
     * http://localhost:8080/springmvc_test_war/exception/notFound
     */
    @RequestMapping("notFound")
    @ResponseBody
    public Role notFound(Long id) {
        throw new RoleException();
    }

    //当前控制器发生RoleException异常时，进入该方法
    @ExceptionHandler(RoleException.class)
    public String HandleRoleException(RoleException e) {
        //返回指定的页面，避免不友好
        return "exception";
    }
}
