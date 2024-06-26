package org.zs.forty.mapper;

import java.util.List;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

public interface UserInfoMapper {
  
  UserInfoVO selectById(Long id);
  
  List<UserInfoVO> selectByUserId(Long userId);
  
  List<UserInfoVO> selectByUseradd(String useradd);
  
  Long insert(UserInfoDTO userInfoDTO);
  
  int update(UserInfoDTO userInfoDTO);
  
  int deleteById(Long id);
}