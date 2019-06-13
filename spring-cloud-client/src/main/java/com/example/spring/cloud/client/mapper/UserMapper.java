package com.example.spring.cloud.client.mapper;

import com.example.spring.cloud.client.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YiJieZhu
 * @since 2019-06-13
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
