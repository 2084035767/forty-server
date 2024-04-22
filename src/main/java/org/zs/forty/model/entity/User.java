package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 用户实体类
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
  private Long id;
  private String username;
  private String nickname;
  private String password;
  private String email;
  private Integer status;
  private Boolean isDelete;
  @TableField(exist = false)
  private List<Role> roles;
  @TableField(exist = false)
  private Collection<? extends GrantedAuthority> authorities;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
  
  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }
  
  @Override public String getUsername() {
    return this.email;
  }
  
  @Override public String getPassword() {
    return this.password;
  }
  
  @Override public boolean isAccountNonLocked() {
    return true;
  }
  
  @Override public boolean isAccountNonExpired() {
    return true;
  }
  
  @Override public boolean isCredentialsNonExpired() {
    return true;
  }
  
  @Override public boolean isEnabled() {
    return this.status == 1;
  }
}