package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.MenuMapper;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.service.MenuService;
@Slf4j
@Service
@MappingIgnore
public class MenuServiceImpl implements MenuService {
    @Resource private MainMapper mainMapper;
    @Resource private MenuMapper menuMapper;

    @Override
    public MenuVO selectMenuById(Long menuId) {
        return menuMapper.selectMenuById(menuId);
    }

//    @Override
//    public List<MenuVO> selectAllMenus() {
//        return null;
//    }

    @Override
    public Boolean update(MenuDTO menuDTO) {
        return menuMapper.update(menuDTO) > 0;
    }

    @Override
    public MenuVO add(MenuDTO menuDTO) {
        return mainMapper.menu2VO(menuMapper.selectById(menuMapper.add(menuDTO)));
    }

    @Override
    public Boolean delete(Long menuId) {
        return menuMapper.delete(menuId) > 0;
    }
}
