package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.LikeMapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

@Slf4j
@Service
@MappingIgnore
public class LikeServiceImpl implements LikeService {


    @Resource private LikeMapper likeMapper;


    @Override
    public LikeVO findById(Long likeId) {
        return likeMapper.selectByLikeId(likeId);
    }

    @Override
    public LikeVO findByUserId(Long userId) {

        return likeMapper.selectByUserId(userId);
    }

    @Override
    public LikeVO findByStoryId(Long storyId) {

        return likeMapper.selectByStoryId(storyId);
    }

    @Override
    public Boolean deleteById(Long likeId) {
        return likeMapper.deleteById(likeId);
    }

    @Override
    public LikeVO insert(LikeDTO likeDTO) {

        return likeMapper.insert(likeDTO);
    }

    @Override
    public Boolean update(LikeDTO likeDTO) {
        return likeMapper.updateById(likeDTO);
    }
}
