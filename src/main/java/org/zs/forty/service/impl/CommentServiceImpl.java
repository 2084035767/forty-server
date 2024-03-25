package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.CommentMapper;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.model.dto.CommentDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.CommentVO;
import org.zs.forty.service.CommentService;

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
public class CommentServiceImpl implements CommentService {
  @Resource private CommentMapper commentMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  public List<CommentVO> findCommentByStoryId(Long storyId, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.commentList2VO(commentMapper.selectByStoryId(storyId));
  }
  
  @Override public List<CommentVO> findCommentByFromUid(Long fromUid, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.commentList2VO(commentMapper.selectByFromUid(fromUid));
  }
  
  @Override public CommentVO addComment(CommentDTO commentDTO) {
    return mainMapper.comment2VO(commentMapper.selectById(commentMapper.insert(commentDTO)));
  }
  
  @Override public Boolean updateComment(CommentDTO commentDTO) {
    return commentMapper.update(commentDTO) > 0;
  }
  
  @Override public Boolean deleteComment(Long id) {
    return commentMapper.delete(id) > 0;
  }
}