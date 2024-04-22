package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserInfoVO selectById(Long id);
    List<UserInfoVO> selectByUserId(Long userId);
    List<UserInfoVO> selectByUseradd(String useradd);
    Long insert (UserInfoDTO userInfoDTO);
    int update(UserInfoDTO userInfoDTO);

    int deleteById(Long id);



}
