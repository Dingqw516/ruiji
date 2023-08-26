package com.Angle.ruiji5.controller;

import com.Angle.ruiji5.common.R;
import com.Angle.ruiji5.entity.Employee;
import com.Angle.ruiji5.service.EmployeeService;
import com.Angle.ruiji5.service.impl.EmployeeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.LambdaConversionException;

/**
 * 功能描述
 *
 * @author: 启文
 * @date: 2023年08月24日 19:01
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    登录方法
    @PostMapping("/login")
    public R login(HttpServletRequest Request, @RequestBody Employee employee){
//        1先对传来的密码进行md5加密
        String pwd=employee.getPassword();
        pwd= DigestUtils.md5DigestAsHex(pwd.getBytes());
//        2查询数据库中的名字看是否存在
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        if (emp==null){
            return R.error("查无此人");
        }
        if(!emp.getPassword().equals(pwd)){
            return R.error("密码错误");
        }
        if(emp.getStatus()!=1){
            return R.error("账号已锁定");
        }
        Request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }
    @PostMapping("/logout")
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("拜拜~");
    }
}
