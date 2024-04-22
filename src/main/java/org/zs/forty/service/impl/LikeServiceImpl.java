package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.LikeMapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

@Slf4j
@Service
@MappingIgnore
public class LikeServiceImpl implements LikeService {
  
  @Resource private LikeMapper likeMapper;
  
  @Override
  public LikeVO insert(LikeDTO likeDTO) {
    return null;
  }
  
  @Override
  public LikeVO findByLikeId(Long likeId, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return likeMapper.selectByLikeId(likeId);
  }
  
  @Override
  public LikeVO findByUserID(Long userid) {
    
    return likeMapper.selectByUserId(userid);
  }
  
  @Override
  public LikeVO findByStoryId(Long storyId) {
    
    return mainMapper.likeList2VO(likeMapper.selectByStoryId(storyId));
  }
  
  @Override
  public Boolean deleteById(Long isDelete) {
    return null;
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