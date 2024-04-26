package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "LikeServiceImpl")
public class LikeServiceImpl implements LikeService {
  
  @Resource private LikeMapper likeMapper;
  
  @Override
  @Cacheable(key = "#likeId")
  public LikeVO findById(Long likeId) {
    return likeMapper.selectByLikeId(likeId);
  }
  
  @Override
  @Cacheable(key = "#userId")
  public List<LikeVO> findByUserId(Long userId) {
    
    return likeMapper.selectByUserId(userId);
  }
  
  @Override
  @Cacheable(key = "#storyId")
  public List<LikeVO> findByStoryId(Long storyId) {
    
    return likeMapper.selectByStoryId(storyId);
  }
  
  @Override
  @CacheEvict(key = "#likeId")
  public Boolean deleteById(Long likeId) {
    return likeMapper.deleteById(likeId) > 0;
  }
  
  @Override
  @Cacheable(key = "#likeDTO.likeId")
  public LikeVO insert(LikeDTO likeDTO) {
    
    return likeMapper.selectByLikeId(likeMapper.insert(likeDTO));
  }
  
  @Override
  @CacheEvict(key = "#likeDTO.likeId")
  public Boolean update(LikeDTO likeDTO) {
    return likeMapper.update(likeDTO) > 0;
  }
}