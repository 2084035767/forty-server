package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.RoleDTO;

@SpringBootTest
class RoleMapperTest {
  @Resource private RoleMapper roleMapper;
  
  @Test
  void selectRoleById() {
    roleMapper.selectRoleById(1L);
  }
  
  @Test
  void selectRoleByRoleId() {
    roleMapper.selectRoleByRoleId(1L);
  }
  
  @Test
  void selectByName() {
    // roleMapper.selectByName("USER");
  }
  
  @Test
  void selectAllRole() {
    roleMapper.selectAllRole();
  }
  
  @Test
  void insert() {
    roleMapper.insert(
        RoleDTO.builder()
            .roleDesc("zy")
            .roleName("zy")
            .build()
    );
  }
  
  @Test
  void update() {
    // roleMapper.update(
    //     RoleDTO.builder()
    //         .roleId(3L)
    //         .roleDesc("222")
    //         .build()
    // );
  }
  
  @Test
  void deleteById() {
    roleMapper.deleteById(4L);
  }
}