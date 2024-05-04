package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.mapstruct.MainMapper;
import org.zs.forty.mapper.StoryMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.service.StoryService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
@Slf4j
@Service
@MappingIgnore
@CacheConfig(cacheNames = "StoryService")
public class StoryServiceImpl implements StoryService {
  @Resource private StoryMapper storyMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  @Cacheable(key = "#pageDTO")
  public List<StoryVO> findAllStoryByList(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.storyList2VO(storyMapper.selectList());
  }
  
  @Cacheable(key = "#root.methodName")
  @Override
  public List<StoryVO> findAllStoryByOpenList() {
    return storyMapper.selectOpenByList();
  }
  
  @Cacheable(key = "#root.methodName")
  @Override public List<StoryVO> sort() {
    return storyMapper.selectListSort();
  }
  
  @Override
  @Cacheable(key = "#createUser")
  public List<StoryVO> findUserStoryByCreateUser(Long createUser, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.storyList2VO(storyMapper.selectListByCreateUser(createUser));
  }
  
  @Cacheable(key = "#createUser")
  @Override public List<StoryVO> findByCreateUser(Long createUser) {
    return mainMapper.storyList2VO(storyMapper.selectListByCreateUser(createUser));
  }
  
  // @Override public List<Story> findStoryByProductId(Integer productId) {
  //   return storyMapper.findByproductId(productId);
  // }
  
  @Override
  @Cacheable(key = "#storyDTO.id")
  public StoryVO addStory(StoryDTO storyDTO) {
    return mainMapper.story2VO(storyMapper.selectById(storyMapper.insert(storyDTO)));
  }
  
  @Override
  @CacheEvict(key = "#createUser")
  public Boolean deleteStory(Long createUser, Long storyId) {
    return storyMapper.deleteById(storyId) > 0;
  }
  
  @Cacheable(key = "#pId")
  @Override
  public List<StoryVO> selectStoryByPId(Long pId) {
    return storyMapper.selectStoryByPId(pId);
  }
  
  @Override
  @CachePut(key = "#storyDTO.id")
  public Boolean updateStory(StoryDTO storyDTO) {
    return storyMapper.updateById(storyDTO) > 0;
  }
  
  @Override public StoryVO findById(Long id) {
    return storyMapper.selectByIdTwo(id);
  }
}