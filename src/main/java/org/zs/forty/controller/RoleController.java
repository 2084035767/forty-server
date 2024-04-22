package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.service.RoleService;

@Tag(name = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {
  @Resource private RoleService roleService;
  
  @Operation(summary = "获取角色列表")
  @PostMapping("/list/{roleId}")
  public RoleVO selectRoleId(@Valid @PathVariable @NotNull Long roleId) {
    return roleService.findRoleId(roleId);
  }
  
  @Operation(summary = "添加角色")
  @PostMapping
  public RoleVO AddRole(@Valid @RequestBody RoleDTO roleDTO) {
    return roleService.insert(roleDTO);
  }
  
  @Operation(summary = "删除角色")
  @DeleteMapping("/{roleId}")
  public ResultVO<Object> DeleteRole(@Valid @PathVariable @NotNull Long roleId) {
    return roleService.deleteById(roleId) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "更新角色")
  @PutMapping
  public ResultVO<Object> UpdateRole(@Valid @RequestBody RoleDTO roleDTO) {
    return roleService.update(roleDTO) ? ResultVO.success() : ResultVO.error();
  }
}