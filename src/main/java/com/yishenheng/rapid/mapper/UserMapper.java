package com.yishenheng.rapid.mapper;

import com.yishenheng.rapid.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yishenheng
 * @since 2020-05-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
