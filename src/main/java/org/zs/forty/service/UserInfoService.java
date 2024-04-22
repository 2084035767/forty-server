package org.zs.forty.service;

import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;

public interface UserInfoService {
    UserInfoVO findByUserInfo(Long id);

    UserInfoVO insert(UserInfoDTO userInfoDTO);

    Boolean update(UserInfoDTO userInfoDTO);

    Boolean deleteById(Long id);

}
