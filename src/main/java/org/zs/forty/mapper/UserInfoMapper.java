package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfoVO> selectById(PageDTO pageDTO);
    List<UserInfoVO> selectByUserId(Long userid);
    List<UserInfoVO> selectByUseradd(String useradd);
    UserInfoVO insert (UserInfoDTO userInfoDTO);
    Boolean update(UserInfoDTO userInfoDTO);

    Boolean delete(Long id);



}
