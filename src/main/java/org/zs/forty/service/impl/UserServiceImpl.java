package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.mapstruct.MainMapper;
import org.zs.forty.mapper.UserMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserDTO;
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
@CacheConfig(cacheNames = "UserService")
public class UserServiceImpl implements UserService {
  
  @Resource private UserMapper userMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  @Cacheable(key = "#username")
  public UserVO findByUsername(String username) {
    return mainMapper.user2VO(userMapper.selectByUsername(username));
  }
  
  @Override
  @Cacheable(key = "#id")
  public UserVO findUserById(Long id) {
    return mainMapper.user2VO(userMapper.selectById(id));
  }
  
  @Override
  @CachePut(key = "#userDTO.id")
  public Boolean updateUser(UserDTO userDTO) {
    return userMapper.updateById(userDTO) > 0;
  }
  
  @Override
  @CacheEvict(key = "#id")
  public Boolean deleteUser(Long id) {
    return userMapper.deleteById(id) > 0;
  }
  
  @Override
  public UserVO addUser(UserDTO userDTO) {
    return null;
  }
  
  // @Override public UserVO addUser(UserDTO userDTO) {
  //   return mainMapper.user2VO(userMapper.selectById(userMapper.insert(SignupDTO)));
  // }
  
  @Override
  @Cacheable(key = "pageDTO")
  public List<UserVO> allUserByList(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.UserList2VO(userMapper.selectList());
  }
  
  @Override public int findUserCount() {
    return userMapper.selectList().size();
  }
}