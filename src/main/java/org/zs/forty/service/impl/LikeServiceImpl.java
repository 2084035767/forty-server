package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.LikeMapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.service.LikeService;

import java.util.List;

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
  public List<LikeVO> findByUserId(Long userId) {
    
    return likeMapper.selectByUserId(userId);
  }
  
  @Override
  public List<LikeVO> findByStoryId(Long storyId) {
    
    return likeMapper.selectByStoryId(storyId);
  }
  
  @Override
  public Boolean deleteById(Long likeId) {
    return likeMapper.deleteById(likeId) > 0;
  }
  
  @Override
  public LikeVO insert(LikeDTO likeDTO) {
    
    return likeMapper.selectByLikeId(likeMapper.insert(likeDTO));
  }
  
  @Override
  public Boolean update(LikeDTO likeDTO) {
    return likeMapper.update(likeDTO) > 0;
  }
}