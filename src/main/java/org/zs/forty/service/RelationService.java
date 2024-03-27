package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RelationDTO;
import org.zs.forty.model.vo.RelationVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
public interface RelationService {
  List<RelationVO> findByProductId(Long productId);
  
  RelationVO findByStoryId(Long storyId);
  
  List<RelationVO> findByCreateUser(Long createUser, PageDTO pageDTO);
  
  RelationVO insert(RelationDTO relationDTO);
  
  Boolean deleteById(Long id);
  
  Boolean deleteByUserId(Long createUser);
  
  Boolean updateById(RelationDTO relationDTO);
}