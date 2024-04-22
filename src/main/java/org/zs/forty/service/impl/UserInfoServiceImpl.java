package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.zs.forty.mapper.UserInfoMapper;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
  
  @Resource private UserInfoMapper userInfoMapper;
  
  @Override
  public UserInfoVO findByUserInfo(Long id) {
    return userInfoMapper.selectById(id);
  }
  
  @Override
  public UserInfoVO insert(UserInfoDTO userInfoDTO) {
    return userInfoMapper.selectById(userInfoMapper.insert(userInfoDTO));
  }
  
  @Override
  public Boolean update(UserInfoDTO userInfoDTO) {
    return userInfoMapper.update(userInfoDTO) >0;
  }
  
  @Override
  public Boolean deleteById(Long id) {
    return userInfoMapper.deleteById(id)>0;
  }
}