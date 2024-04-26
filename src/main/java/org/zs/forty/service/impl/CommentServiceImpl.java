package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.CommentMapper;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.model.dto.CommentDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.CommentVO;
import org.zs.forty.service.CommentService;

import java.util.List;

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
@CacheConfig(cacheNames = "CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
  @Resource private CommentMapper commentMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  @Cacheable(key = "#storyId")
  public List<CommentVO> findCommentByStoryId(Long storyId, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.commentList2VO(commentMapper.selectByStoryId(storyId));
  }
  
  @Override
  @Cacheable(key = "#fromUid")
  public List<CommentVO> findCommentByFromUid(Long fromUid, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.commentList2VO(commentMapper.selectByFromUid(fromUid));
  }
  
  @Override
  @Cacheable(key = "#commentDTO.id")
  public CommentVO addComment(CommentDTO commentDTO) {
    return mainMapper.comment2VO(commentMapper.selectById(commentMapper.insert(commentDTO)));
  }
  
  @Override
  @CachePut(key = "#commentDTO.id")
  public Boolean updateComment(CommentDTO commentDTO) {
    return commentMapper.update(commentDTO) > 0;
  }
  
  @Override
  @CacheEvict(key = "#id")
  public Boolean deleteComment(Long id) {
    return commentMapper.delete(id) > 0;
  }
}