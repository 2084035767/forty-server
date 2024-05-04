package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.MenuDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.model.vo.ResultVO;
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
  @GetMapping("/{menuId}")
  public MenuVO selectMenuById(@Valid @NotNull @PathVariable("menuId") Long menuId) {
    return menuService.selectMenuById(menuId);
  }
  
  /**
   * 查询所有菜单信息
   */
  @Operation(summary = "获取菜单信息")
  @PostMapping("/list")
  public List<MenuVO> selectAllMenus(@RequestBody PageDTO pageDTO) {
    return menuService.findAllMenus(pageDTO);
  }
  
  /**
   * 更新菜单信息
   */
  @Operation(summary = "更新菜单信息")
  @PutMapping
  public ResultVO<Object> update(@Valid @RequestBody MenuDTO menuDTO) {
    return menuService.update(menuDTO) ? ResultVO.success() : ResultVO.error();
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
  public ResultVO<Object> delete(@NotNull @Valid @PathVariable Long menuId) {
    return menuService.delete(menuId) ? ResultVO.success() : ResultVO.error();
  }
}