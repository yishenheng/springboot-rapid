package com.yishenheng.rapid.converter;

import com.yishenheng.rapid.dto.UserDTO;
import com.yishenheng.rapid.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author yishenheng
 * @date 2020-05-25 14:10
 */
@Mapper
public interface UserConverterBasic {

    UserConverterBasic INSTANCE = Mappers.getMapper(UserConverterBasic.class);


    /**
     * user转换成userDTO
     *
     * @param user
     * @return
     */
    UserDTO userConvertUserDTO(User user);
}
