package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.RelationMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RelationDTO;
import org.zs.forty.model.vo.RelationVO;
import org.zs.forty.service.RelationService;

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
public class RelationServiceImpl implements RelationService {
  @Resource private RelationMapper relationMapper;
  @Resource private MainMapper mainMapper;
  
  @Override public List<RelationVO> findByProductId(Long productId) {
    return mainMapper.relationList2VO(relationMapper.selectByProductId(productId));
  }
  
  @Override public RelationVO findByStoryId(Long storyId) {
    return mainMapper.relation2VO(relationMapper.selectByStoryId(storyId));
  }
  
  @Override public List<RelationVO> findByCreateUser(Long createUser, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.relationList2VO(relationMapper.selectByCreateUser(createUser));
  }
  
  @Override public RelationVO insert(RelationDTO relationDTO) {
    return mainMapper.relation2VO(relationMapper.selectById(relationMapper.insert(relationDTO)));
  }
  
  @Override public Boolean deleteById(Long id) {
    return relationMapper.deleteById(id) > 0;
  }
  
  @Override public Boolean deleteByUserId(Long createUser) {
    return relationMapper.deleteByCreateUser(createUser) > 0;
  }
  
  @Override public Boolean updateById(RelationDTO relationDTO) {
    return relationMapper.updateById(relationDTO) > 0;
  }
}