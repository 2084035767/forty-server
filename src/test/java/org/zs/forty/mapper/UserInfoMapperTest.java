package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.UserInfoDTO;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserInfoMapperTest {
@Resource private UserInfoMapper userInfoMapper;
    @Test
    void selectById() {
        userInfoMapper.selectById(1L);
    }

    @Test
    void selectByUserId() {
        userInfoMapper.selectByUserId(5L);
    }

    @Test
    void insert() {
        Long test = userInfoMapper.insert(
                UserInfoDTO.builder()
                        .userId(6L)
                        .userAdd("达州")
                        .userAge(22)
                        .userSex(0)
                        .userImg("111")
                        .userEmail("65897")
                        .userPhone("45678900")
                        .build()
        );
    }

    @Test
    void update() {
        userInfoMapper.update(
                UserInfoDTO.builder()
                        .id(1L)
                        .userAdd("444")
                        .build()
        );
    }

    @Test
    void deleteById() {
        userInfoMapper.deleteById(1L);
    }
}