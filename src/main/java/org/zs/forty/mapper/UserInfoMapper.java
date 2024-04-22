package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfoVO> selectById(Long id);
    List<UserInfoVO> selectByUserId(Long userId);
    List<UserInfoVO> selectByUseradd(String useradd);
    UserInfoVO insert (UserInfoDTO userInfoDTO);
    Boolean update(UserInfoDTO userInfoDTO);

    Boolean deleteById(Long id);



}
