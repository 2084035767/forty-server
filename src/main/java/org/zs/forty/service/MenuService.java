package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.MenuVO;

public interface MenuService {
    MenuVO selectMenuById(Long menuId);
    //    List<MenuVO> selectAllMenus();
    
    Boolean update(MenuDTO menuDTO);
    
    MenuVO add(MenuDTO menuDTO);
    
    Boolean delete(Long menuId);
    
    List<MenuVO> findAllMenus(PageDTO pageDTO);
}