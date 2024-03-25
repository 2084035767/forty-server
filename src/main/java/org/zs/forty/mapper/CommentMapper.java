package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.CommentDTO;
import org.zs.forty.model.entity.Comment;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/1/14
 * @Description:
 **/
@Mapper
public interface CommentMapper {
  
  Comment selectById(Long id);
  
  List<Comment> selectByStoryId(Long storyId);
  
  List<Comment> selectByFromUid(Long fromUid);
  
  Long insert(CommentDTO commentDTO);
  
  int update(CommentDTO commentDTO);
  
  int delete(Long id);
  
  int deleteByStoryId(Long storyId);
  
  int deleteByFromUid(Long fromUid);
}