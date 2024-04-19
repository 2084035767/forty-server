package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.service.RoleService;

@Tag(name="角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource private RoleService roleService;
    @Operation(summary="获取角色列表")
   @RequestMapping("/list")
    public PageInfo<RoleVO> AllRole(@Valid @RequestBody PageDTO pageDTO,@Valid@RequestBody Long id){
        return new PageInfo<>(roleService.findAllRoles(pageDTO,id)) ;
    }
    @Operation(summary = "添加角色")
    @RequestMapping("/add")
    public RoleVO addRole(@Valid @RequestBody RoleDTO roleDTO){
      return  roleService.insert(roleDTO);
    }
    @Operation(summary = "删除角色")
    @RequestMapping("/delete")
    public Boolean deleteRole(@Valid @RequestBody Long Id){
       return roleService.deleteById(Id);
    }
   @Operation(summary = "更新角色")
    @RequestMapping("/update")
    public Boolean updateRole(@Valid @RequestBody RoleDTO roleDTO){
        return roleService.update(roleDTO);
   }


}
