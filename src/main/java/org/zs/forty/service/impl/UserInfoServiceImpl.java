package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.mapper.UserInfoMapper;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.service.UserInfoService;

@Service
@CacheConfig(cacheNames = "UserInfoServiceImpl")
public class UserInfoServiceImpl implements UserInfoService {
  
  @Resource private UserInfoMapper userInfoMapper;
  
  @Override
  @Cacheable(key = "#id")
  public UserInfoVO findByUserInfo(Long id) {
    return userInfoMapper.selectById(id);
  }
  
  @Override
  @Cacheable(key = "#userInfoDTO.id")
  public UserInfoVO insert(UserInfoDTO userInfoDTO) {
    return userInfoMapper.selectById(userInfoMapper.insert(userInfoDTO));
  }
  
  @Override
  @CachePut(key = "#userInfoDTO.id")
  public Boolean update(UserInfoDTO userInfoDTO) {
    return userInfoMapper.update(userInfoDTO) >0;
  }
  
  @Override
  @CacheEvict(key = "#id")
  public Boolean deleteById(Long id) {
    return userInfoMapper.deleteById(id)>0;
  }
}