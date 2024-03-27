package org.zs.forty.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.Comment;
import org.zs.forty.model.entity.Menu;
import org.zs.forty.model.entity.Product;
import org.zs.forty.model.entity.Relation;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.entity.Story;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.entity.UserInfo;
import org.zs.forty.model.vo.CommentVO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.model.vo.RelationVO;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.model.vo.StoryVO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.model.vo.UserVO;

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
  
  List<RoleVO> roleList2VO(List<Role> vo);
  
  StoryVO story2VO(Story po);
  
  List<StoryVO> storyList2VO(List<Story> vo);
  
  UserInfoVO userInfo2VO(UserInfo po);
  
  List<UserInfoVO> userInfoList2VO(List<UserInfo> vo);
  
  RelationVO relation2VO(Relation po);
  
  List<RelationVO> relationList2VO(List<Relation> vo);
  
  MenuVO menu2VO(Menu po);
  
  List<MenuVO> menuList2VO(List<Menu> vo);
  
  UserDTO Signup2DTO(SignupDTO dto);
  
  EmailDTO email2DTO(SignupDTO dto);
}