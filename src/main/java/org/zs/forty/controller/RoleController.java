package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.service.RoleService;

@Tag(name="角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource private RoleService roleService;
    @Operation(summary="获取角色列表")
   @PostMapping("/list")
    public PageInfo<RoleVO> selectRoleId(@Valid@PathVariable@NotNull Long roleId){
        return new PageInfo<>(roleService.findRoleId(roleId));
    }
    @Operation(summary = "添加角色")
    @PostMapping()
    public RoleVO AddRole(@Valid @RequestBody RoleDTO roleDTO){
      return  roleService.insert(roleDTO);
    }
    @Operation(summary = "删除角色")
    @DeleteMapping("/roleId")
    public Boolean DeleteRole(@Valid @RequestBody@NotNull Long roleId){
       return roleService.deleteById(roleId);
    }
   @Operation(summary = "更新角色")
    @PutMapping()
    public Boolean UpdateRole(@Valid @RequestBody RoleDTO roleDTO){
        return roleService.update(roleDTO);
   }


}
