package org.zs.forty.common.mapstruct;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.Comment;
import org.zs.forty.model.entity.Log;
import org.zs.forty.model.entity.Menu;
import org.zs.forty.model.entity.Msg;
import org.zs.forty.model.entity.Order;
import org.zs.forty.model.entity.Product;
import org.zs.forty.model.entity.Rank;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.entity.Story;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.entity.UserInfo;
import org.zs.forty.model.vo.CommentVO;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.model.vo.MenuVO;
import org.zs.forty.model.vo.MsgVO;
import org.zs.forty.model.vo.OrderVO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.model.vo.RankVO;
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
  
  UserDTO user2DTO(User po);
  
  List<UserVO> UserList2VO(List<User> vo);
  
  CommentVO comment2VO(Comment po);
  
  List<CommentVO> commentList2VO(List<Comment> vo);
  
  ProductVO product2VO(Product po);
  
  List<ProductVO> productList2VO(List<Product> vo);
  
  RoleVO role2VO(Role po);
  
  // List<RoleVO> roleList2VO(List<Role> vo);
  
  StoryVO story2VO(Story po);
  
  @Mapping(target = "createUser", ignore = true)
  List<StoryVO> storyList2VO(List<Story> vo);
  
  UserInfoVO userInfo2VO(UserInfo po);
  
  // List<UserInfoVO> userInfoList2VO(List<UserInfo> vo);
  
  OrderVO order2VO(Order po);
  
  List<OrderVO> orderList2VO(List<Order> vo);
  
  MenuVO menu2VO(Menu po);
  
  // List<MenuVO> menuList2VO(List<Menu> vo);
  
  // UserDTO Signup2DTO(SignupDTO dto);
  
  EmailDTO email2DTO(SignupDTO dto);
  
  LogVO log2VO(Log po);
  
  // List<LogVO> logList2VO(List<Log> vo);
  
  MsgVO msg2VO(Msg po);
  
  // List<MsgVO> msgList2VO(List<Msg> vo);
  
  RankVO rank2VO(Rank po);
  
  // List<RankVO> rankList2VO(List<Rank> vo);
}