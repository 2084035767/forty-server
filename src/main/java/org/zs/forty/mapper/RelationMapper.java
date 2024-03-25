package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.RelationDTO;
import org.zs.forty.model.entity.Relation;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/1/14
 * @Description:
 **/
@Mapper
public interface RelationMapper extends BaseMapper<Relation> {
  
  Relation selectById(Long id);
  
  List<Relation> selectByProductId(Long productId);
  
  Relation selectByStoryId(Long storyId);
  
  List<Relation> selectByCreateUser(Long createUser);
  
  Long insert(RelationDTO relationDTO);
  
  int deleteById(Long id);
  
  int deleteByCreateUser(Long UserId);
  
  int updateById(RelationDTO relationDTO);
}