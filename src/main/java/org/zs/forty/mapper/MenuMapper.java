package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.entity.Menu;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/5
 * @Description:
 **/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
  // List<Menu> selectMenuByRoleId(Long roleIds);
}