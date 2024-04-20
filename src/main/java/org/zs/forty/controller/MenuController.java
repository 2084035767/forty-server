package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.service.MenuService;

@Tag(name = "菜单管理")
@RequestMapping("/api/menu")
@RestController
public class MenuController {
    @Resource private MenuService menuService;
    /**
     * 根据菜单ID查询菜单信息
     */
    @Operation(summary = "根据菜单ID查询菜单信息")
    @PostMapping("/{menuId}")
    public MenuVO selectMenuById(@Valid @NotNull @PathVariable("menuId") Long menuId) {
        return menuService.selectMenuById(menuId);
    }

    /**
     * 查询所有菜单信息
     */
//    @Operation(summary = "获取菜单信息")
//    @PostMapping("/selectAllMenus")
//    public List<MenuVO> selectAllMenus() {
//        return menuService.selectAllMenus();
//    }

    /**
     * 更新菜单信息
     */
    @Operation(summary = "更新菜单信息")
    @PutMapping
    public Boolean update(@Valid @RequestBody MenuDTO menuDTO) {
        return menuService.update(menuDTO);
    }

    /**
     * 添加菜单信息
     */
    @Operation(summary = "添加菜单信息")
    @PostMapping
    public MenuVO add(@Valid @RequestBody MenuDTO menuDTO) {
        return menuService.add(menuDTO);
    }

    /**
     * 删除菜单信息
     */
    @Operation(summary = "删除菜单信息")
    @DeleteMapping("/{menuId}")
    public Boolean delete(@NotNull @Valid @PathVariable Long menuId) {
        return menuService.delete(menuId);
    }
}
