package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.LikeMapper;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

import java.util.List;

@Slf4j
@Service
@MappingIgnore
public class LikeServiceImpl implements LikeService {

    @Override
    public LikeVO insert(LikeDTO likeDTO) {
        return null;
    }

    @Resource private LikeMapper likeMapper;
    @Resource private MainMapper mainMapper;


    @Override
    public List<LikeVO> findByLikeId(Long likeId, PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        return  mainMapper.likeList2VO(likeMapper.selectByLikeId(likeId),pageDTO);
    }
    @Override
    public LikeVO findByUserID(Long userid) {

        return mainMapper.likeList2VO(likeMapper.selectByUserId(userid));
    }

    @Override
    public LikeVO findByStoryId(Long storyId) {

        return mainMapper.likeList2VO(likeMapper.selectByStoryId(storyId));
    }

    @Override
    public Boolean deleteById(Long isDelete) {return null;
    }

    @Override
    public LikeVO delete(Long likeId) {
        return likeMapper.deleteById(likeId);
    }

    @Override
    public LikeVO update(LikeDTO likeDTO) {
        return likeMapper.updateById(likeDTO);
    }
}
