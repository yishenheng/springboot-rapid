package com.yishenheng.rapid.controller;


import cn.hutool.json.JSONUtil;
import com.yishenheng.rapid.common.BaseController;
import com.yishenheng.rapid.common.ResultData;
import com.yishenheng.rapid.dto.UserDTO;
import com.yishenheng.rapid.entity.User;
import com.yishenheng.rapid.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yishenheng
 * @since 2020-05-25
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息", tags = "用户")
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResultData<UserDTO> getUserInfoById(@PathVariable("id") Long id) {
        return ok(this.userService.getUserInfoById(id));
    }

}

