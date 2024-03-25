package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.StoryMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.service.StoryService;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/2/20
 * @Description:
 **/
@Slf4j
@Service
@MappingIgnore
public class StoryServiceImpl implements StoryService {
  @Resource private StoryMapper storyMapper;
  @Resource private MainMapper mainMapper;
  
  @Override public List<StoryVO> findAllStoryByList(PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.storyList2VO(storyMapper.selectList());
  }
  
  @Override public List<StoryVO> findUserStoryByCreateUser(Long createUser, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.storyList2VO(storyMapper.selectListByCreateUser(createUser));
  }
  
  // @Override public List<Story> findStoryByProductId(Integer productId) {
  //   return storyMapper.findByproductId(productId);
  // }
  
  @Override public StoryVO addStory(StoryDTO storyDTO) {
    return mainMapper.story2VO(storyMapper.selectById(storyMapper.insert(storyDTO)));
  }
  
  @Override public Boolean deleteStory(Long createUser, Long storyId) {
    return storyMapper.deleteById(storyId) > 0;
  }
  
  @Override public Boolean updateStory(StoryDTO storyDTO) {
    return storyMapper.updateById(storyDTO) > 0;
  }
}