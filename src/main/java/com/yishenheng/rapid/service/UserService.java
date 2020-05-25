package com.yishenheng.rapid.service;

import com.yishenheng.rapid.dto.UserDTO;
import com.yishenheng.rapid.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yishenheng
 * @since 2020-05-25
 */
public interface UserService extends IService<User> {

    /**
     * 根据id获取用户详情信息
     *
     * @param id 用户id
     * @return 详情信息
     */
    UserDTO getUserInfoById(Long id);

}
