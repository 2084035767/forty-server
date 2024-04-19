package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.UserMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.UserService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
@Slf4j
@Service
@MappingIgnore
public class UserServiceImpl implements UserService {
  
  @Resource private UserMapper userMapper;
  @Resource private MainMapper mainMapper;
  
  @Override public UserVO findByUsername(String username) {
    return mainMapper.user2VO(userMapper.selectByUsername(username));
  }
  
  @Override public UserVO findUserById(Long id) {
    User user = userMapper.selectById(id);
    return mainMapper.user2VO(user);
  }
  
  @Override public Boolean updateUser(UserDTO userDTO) {
    return userMapper.updateById(userDTO) > 0;
  }
  
  @Override public Boolean deleteUser(Long id) {
    return userMapper.deleteById(id) > 0;
  }
  
  @Override public UserVO addUser(UserDTO userDTO) {
    return null;
  }
  
  // @Override public UserVO addUser(UserDTO userDTO) {
  //   return mainMapper.user2VO(userMapper.selectById(userMapper.insert(SignupDTO)));
  // }
  
  @Override public List<UserVO> allUserByList(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.UserList2VO(userMapper.selectList());
  }
}