package org.zs.forty.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.*;
import org.zs.forty.model.vo.*;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@Mapper(componentModel = "spring")
public interface MainMapper {
  
  /**
   *
   */
  UserVO user2VO(User po);
  
  List<UserVO> UserList2VO(List<User> vo);
  
  CommentVO comment2VO(Comment po);
  
  List<CommentVO> commentList2VO(List<Comment> vo);
  
  ProductVO product2VO(Product po);
  
  List<ProductVO> productList2VO(List<Product> vo);
  
  RoleVO role2VO(Role po);
  
  List<RoleVO> roleList2VO(Long vo);
  
  StoryVO story2VO(Story po);
  
  List<StoryVO> storyList2VO(List<Story> vo);
  
  UserInfoVO userInfo2VO(UserInfo po);
  
  List<UserInfoVO> userInfoList2VO(List<UserInfo> vo);
  
  OrderVO relation2VO(Order po);
  
  List<OrderVO> relationList2VO(List<Order> vo);
  
  MenuVO menu2VO(Menu po);
  
  List<MenuVO> menuList2VO(List<Menu> vo);
  
  UserDTO Signup2DTO(SignupDTO dto);
  
  EmailDTO email2DTO(SignupDTO dto);
  

  LikeVO likeList2VO(List<Like> likes);

  List<LikeVO> likeList2VO(List<Like> likes, PageDTO pageDTO);

  List<RoleVO> roleList2VO(Role role);

  RoleVO roleList2VO(Long insert);

  Boolean roleList2VO(int delete);

  List<UserInfoVO> userInfoList2VO(UserInfo userInfo);

  UserInfoVO userInfoList2VO(Long insert);

  Boolean userInfoList2VO(int delete);
}