package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.MenuDTO;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MenuMapperTest {
   @Resource private MenuMapper menuMapper;
    @Test
    void selectMenuById() {
        menuMapper.selectMenuById(2L);
    }

    @Test
    void update() {
        menuMapper.update(
                MenuDTO.builder()
                        .menuId(1L)
                        .menuName("用户接口1")
                        .build()
        );
    }

    @Test
    void add() {
        Long test = menuMapper.add(
                MenuDTO.builder()
                        .menuName("111")
                        .menuMark("222")
                        .menuPath("555")
                        .build()
        );
    }

    @Test
    void delete() {
        menuMapper.delete(5L);
    }
}