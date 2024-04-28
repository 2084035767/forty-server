package org.zs.forty.mapper;

import java.util.List;
import org.zs.forty.model.dto.StoryDTO;
import org.zs.forty.model.entity.Story;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description:
 **/

public interface StoryMapper {
  /**
   * 根据用户id查询故事
   *
   * @param createUser 用户id
   * @return 故事列表
   */
  
  List<Story> selectListByCreateUser(Long createUser);
  
  /**
   * 查询所有故事
   *
   * @return 故事列表
   */
  
  List<Story> selectList();
  
  List<Story> selectListSort();
  
  List<Story> selectOpenByList();
  
  // @Select("select id,title,context,storyView,storyLike from t_story where id in (select story_id from t_relation where product_id =\n"
  //     + "#{productId})")
  // List<Story> selectByproductId(Long productId);
  
  /**
   * 根据id查询故事
   *
   * @param id 故事id
   * @return 故事
   */
  Story selectById(Long id);
  
  int updateById(StoryDTO storyDTO);
  
  Long insert(StoryDTO storyDTO);
  
  int deleteById(Long id);
}