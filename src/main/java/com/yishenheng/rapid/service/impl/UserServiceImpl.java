package com.yishenheng.rapid.service.impl;

import com.yishenheng.rapid.common.BusinessException;
import com.yishenheng.rapid.common.ResultCode;
import com.yishenheng.rapid.converter.UserConverterBasic;
import com.yishenheng.rapid.dto.UserDTO;
import com.yishenheng.rapid.entity.User;
import com.yishenheng.rapid.mapper.UserMapper;
import com.yishenheng.rapid.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yishenheng
 * @since 2020-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public UserDTO getUserInfoById(Long id) {
        return UserConverterBasic.INSTANCE.userConvertUserDTO(this.getById(id));
    }
}
