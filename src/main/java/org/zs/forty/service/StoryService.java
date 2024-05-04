package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.vo.StoryVO;

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
  
  List<StoryVO> sort();
  
  List<StoryVO> findUserStoryByCreateUser(Long createUser, PageDTO pageDTO);
  
  List<StoryVO> findByCreateUser(Long createUser);
  
  // List<Story> findStoryByProductId(Long productId);
  List<StoryVO> selectStoryByPId(Long pId);
  
  StoryVO addStory(StoryDTO storyDTO);
  
  Boolean deleteStory(Long createUser, Long storyId);
  
  Boolean updateStory(StoryDTO storyDTO);
  
  StoryVO findById(Long id);
}