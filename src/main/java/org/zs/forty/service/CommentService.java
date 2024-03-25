package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.CommentDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.CommentVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/2/20
 * @Description:
 **/
public interface CommentService {
  // CommentDTO findCommentById(Integer id);
  
  List<CommentVO> findCommentByStoryId(Long storyId, PageDTO pageDTO);
  
  List<CommentVO> findCommentByFromUid(Long fromUid, PageDTO pageDTO);
  
  CommentVO addComment(CommentDTO commentDTO);
  
  Boolean updateComment(CommentDTO commentDTO);
  
  Boolean deleteComment(Long id);
}