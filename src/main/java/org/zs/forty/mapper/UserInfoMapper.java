package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.entity.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    UserInfo selectById(Long id);
    List<UserInfoMapper> selectByUserId(Long userid);
    List<UserInfoMapper> selectByUseradd(String useradd);
    Long insert (UserInfoDTO userInfoDTO);
    Long update(UserInfoDTO userInfoDTO);

    int delete(Long id);


}
