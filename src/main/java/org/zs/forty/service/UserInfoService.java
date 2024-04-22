package org.zs.forty.service;

import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

import java.util.List;

public interface UserInfoService {
    List<UserInfoVO> findAll(PageDTO pageDTO);

    UserInfoVO insert(UserInfoDTO userInfoDTO);

    Boolean update(UserInfoDTO userInfoDTO);

    Boolean deleteById(Long id);

}
