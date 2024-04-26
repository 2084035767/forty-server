package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.entity.Menu;
import org.zs.forty.model.vo.MenuVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description:
 **/

public interface MenuMapper extends BaseMapper<Menu> {
  MenuVO selectMenuById(Long menuId);
  
  //   List<Menu> selectAllMenus();
  int update(MenuDTO menuDTO);
  
  Long add(MenuDTO menuDTO);
  
  int delete(Long menuId);
  
  List<MenuVO> selectAllMenus();
}