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
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.MenuMapper;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.service.MenuService;

import java.util.List;

@Slf4j
@Service
@MappingIgnore
@CacheConfig(cacheNames = "MenuServiceImpl")
public class MenuServiceImpl implements MenuService {
    @Resource private MainMapper mainMapper;
    @Resource private MenuMapper menuMapper;
    
    @Override
    @Cacheable(key = "#menuId")
    public MenuVO selectMenuById(Long menuId) {
        return menuMapper.selectMenuById(menuId);
    }
    
    //    @Override
    //    public List<MenuVO> selectAllMenus() {
    //        return null;
    //    }
    
    @Override
    @CachePut(key = "#menuDTO.menuId")
    public Boolean update(MenuDTO menuDTO) {
        return menuMapper.update(menuDTO) > 0;
    }
    
    @Override
    @Cacheable(key = "#menuDTO.menuId")
    public MenuVO add(MenuDTO menuDTO) {
        return mainMapper.menu2VO(menuMapper.selectById(menuMapper.add(menuDTO)));
    }
    
    @Override
    @CacheEvict(key = "#menuId")
    public Boolean delete(Long menuId) {
        return menuMapper.delete(menuId) > 0;
    }
    
    @Override
    @Cacheable(key = "#pageDTO")
    public List<MenuVO> findAllMenus(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        return menuMapper.selectAllMenus();
    }
}