package org.zs.forty.service;

import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.vo.StoryVO;

import java.util.List;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/

public interface StoryService {
  List<StoryVO> findAllStoryByList(PageDTO pageDTO);
  List<StoryVO> findAllStoryByOpenList();

  List<StoryVO> findUserStoryByCreateUser(Long createUser, PageDTO pageDTO);
  
  // List<Story> findStoryByProductId(Long productId);
  
  StoryVO addStory(StoryDTO storyDTO);
  
  Boolean deleteStory(Long createUser, Long storyId);
  
  Boolean updateStory(StoryDTO storyDTO);
}