package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.UserInfoMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.service.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {

    @Resource private UserInfoMapper userInfoMapper;
    @Resource private MainMapper mainMapper;
    @Override
    public List<UserInfoVO> findAll(PageDTO pageDTO,Long id) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        return mainMapper.userInfoList2VO(userInfoMapper.selectById(id));
    }

    @Override
    public UserInfoVO insert(UserInfoDTO userInfoDTO) {
        return mainMapper.userInfoList2VO(userInfoMapper.insert(userInfoDTO));
    }

    @Override
    public UserInfoVO update(UserInfoDTO userInfoDTO) {
        return mainMapper.userInfoList2VO(userInfoMapper.update(userInfoDTO));
    }

    @Override
    public Boolean delete(Long id) {
        return mainMapper.userInfoList2VO(userInfoMapper.delete(id));
    }
}
