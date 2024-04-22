package org.zs.forty.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
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

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T11:20:16+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class MainMapperImpl implements MainMapper {

    @Override
    public UserVO user2VO(User po) {
        if ( po == null ) {
            return null;
        }

        UserVO.UserVOBuilder userVO = UserVO.builder();

        userVO.id( po.getId() );
        userVO.username( po.getUsername() );
        userVO.nickname( po.getNickname() );
        userVO.email( po.getEmail() );
        userVO.status( po.getStatus() );

        return userVO.build();
    }

    @Override
    public List<UserVO> UserList2VO(List<User> vo) {
        if ( vo == null ) {
            return null;
        }

        List<UserVO> list = new ArrayList<UserVO>( vo.size() );
        for ( User user : vo ) {
            list.add( user2VO( user ) );
        }

        return list;
    }

    @Override
    public CommentVO comment2VO(Comment po) {
        if ( po == null ) {
            return null;
        }

        CommentVO.CommentVOBuilder commentVO = CommentVO.builder();

        commentVO.id( po.getId() );
        commentVO.fromUid( po.getFromUid() );
        commentVO.toUid( po.getToUid() );
        commentVO.storyId( po.getStoryId() );
        commentVO.context( po.getContext() );

        return commentVO.build();
    }

    @Override
    public List<CommentVO> commentList2VO(List<Comment> vo) {
        if ( vo == null ) {
            return null;
        }

        List<CommentVO> list = new ArrayList<CommentVO>( vo.size() );
        for ( Comment comment : vo ) {
            list.add( comment2VO( comment ) );
        }

        return list;
    }

    @Override
    public ProductVO product2VO(Product po) {
        if ( po == null ) {
            return null;
        }

        ProductVO.ProductVOBuilder productVO = ProductVO.builder();

        productVO.id( po.getId() );
        productVO.productName( po.getProductName() );
        productVO.productInfo( po.getProductInfo() );
        if ( po.getProductPrice() != null ) {
            productVO.productPrice( String.valueOf( po.getProductPrice() ) );
        }
        productVO.productImg( po.getProductImg() );
        productVO.status( po.getStatus() );
        productVO.category( po.getCategory() );

        return productVO.build();
    }

    @Override
    public List<ProductVO> productList2VO(List<Product> vo) {
        if ( vo == null ) {
            return null;
        }

        List<ProductVO> list = new ArrayList<ProductVO>( vo.size() );
        for ( Product product : vo ) {
            list.add( product2VO( product ) );
        }

        return list;
    }

    @Override
    public RoleVO role2VO(Role po) {
        if ( po == null ) {
            return null;
        }

        RoleVO.RoleVOBuilder roleVO = RoleVO.builder();

        roleVO.roleName( po.getRoleName() );
        roleVO.roleDesc( po.getRoleDesc() );

        return roleVO.build();
    }

    @Override
    public List<RoleVO> roleList2VO(List<Role> vo) {
        if ( vo == null ) {
            return null;
        }

        List<RoleVO> list = new ArrayList<RoleVO>( vo.size() );
        for ( Role role : vo ) {
            list.add( role2VO( role ) );
        }

        return list;
    }

    @Override
    public StoryVO story2VO(Story po) {
        if ( po == null ) {
            return null;
        }

        StoryVO.StoryVOBuilder storyVO = StoryVO.builder();

        storyVO.id( po.getId() );
        storyVO.createUser( po.getCreateUser() );
        storyVO.title( po.getTitle() );
        storyVO.context( po.getContext() );
        storyVO.storyView( po.getStoryView() );
        storyVO.storyLike( po.getStoryLike() );
        storyVO.isOpen( po.getIsOpen() );

        return storyVO.build();
    }

    @Override
    public List<StoryVO> storyList2VO(List<Story> vo) {
        if ( vo == null ) {
            return null;
        }

        List<StoryVO> list = new ArrayList<StoryVO>( vo.size() );
        for ( Story story : vo ) {
            list.add( story2VO( story ) );
        }

        return list;
    }

    @Override
    public UserInfoVO userInfo2VO(UserInfo po) {
        if ( po == null ) {
            return null;
        }

        UserInfoVO.UserInfoVOBuilder userInfoVO = UserInfoVO.builder();

        userInfoVO.id( po.getId() );
        userInfoVO.userId( po.getUserId() );
        userInfoVO.userAdd( po.getUserAdd() );
        userInfoVO.userPhone( po.getUserPhone() );
        userInfoVO.userEmail( po.getUserEmail() );
        userInfoVO.userSex( po.getUserSex() );
        userInfoVO.userAge( po.getUserAge() );
        userInfoVO.userImg( po.getUserImg() );

        return userInfoVO.build();
    }

    @Override
    public List<UserInfoVO> userInfoList2VO(List<UserInfo> vo) {
        if ( vo == null ) {
            return null;
        }

        List<UserInfoVO> list = new ArrayList<UserInfoVO>( vo.size() );
        for ( UserInfo userInfo : vo ) {
            list.add( userInfo2VO( userInfo ) );
        }

        return list;
    }

    @Override
    public OrderVO relation2VO(Order po) {
        if ( po == null ) {
            return null;
        }

        OrderVO orderVO = new OrderVO();

        orderVO.setId( po.getId() );
        orderVO.setCreateUser( po.getCreateUser() );
        orderVO.setStoryId( po.getStoryId() );
        orderVO.setProductId( po.getProductId() );
        orderVO.setStatus( po.getStatus() );

        return orderVO;
    }

    @Override
    public List<OrderVO> relationList2VO(List<Order> vo) {
        if ( vo == null ) {
            return null;
        }

        List<OrderVO> list = new ArrayList<OrderVO>( vo.size() );
        for ( Order order : vo ) {
            list.add( relation2VO( order ) );
        }

        return list;
    }

    @Override
    public MenuVO menu2VO(Menu po) {
        if ( po == null ) {
            return null;
        }

        MenuVO.MenuVOBuilder menuVO = MenuVO.builder();

        menuVO.menuPath( po.getMenuPath() );
        menuVO.menuName( po.getMenuName() );
        menuVO.menuMark( po.getMenuMark() );

        return menuVO.build();
    }

    @Override
    public List<MenuVO> menuList2VO(List<Menu> vo) {
        if ( vo == null ) {
            return null;
        }

        List<MenuVO> list = new ArrayList<MenuVO>( vo.size() );
        for ( Menu menu : vo ) {
            list.add( menu2VO( menu ) );
        }

        return list;
    }

    @Override
    public UserDTO Signup2DTO(SignupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( dto.getId() );
        userDTO.username( dto.getUsername() );
        userDTO.nickname( dto.getNickname() );
        userDTO.password( dto.getPassword() );
        userDTO.email( dto.getEmail() );

        return userDTO.build();
    }

    @Override
    public EmailDTO email2DTO(SignupDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setNickname( dto.getNickname() );
        emailDTO.setEmail( dto.getEmail() );

        return emailDTO;
    }

    @Override
    public LogVO log2VO(Log po) {
        if ( po == null ) {
            return null;
        }

        LogVO.LogVOBuilder logVO = LogVO.builder();

        logVO.ipAdd( po.getIpAdd() );
        logVO.logId( po.getLogId() );
        logVO.logLevel( po.getLogLevel() );
        logVO.logName( po.getLogName() );
        logVO.message( po.getMessage() );
        logVO.userId( po.getUserId() );

        return logVO.build();
    }

    @Override
    public List<LogVO> logList2VO(List<Log> vo) {
        if ( vo == null ) {
            return null;
        }

        List<LogVO> list = new ArrayList<LogVO>( vo.size() );
        for ( Log log : vo ) {
            list.add( log2VO( log ) );
        }

        return list;
    }

    @Override
    public MsgVO msg2VO(Msg po) {
        if ( po == null ) {
            return null;
        }

        MsgVO.MsgVOBuilder msgVO = MsgVO.builder();

        msgVO.isArchive( po.getIsArchive() );
        msgVO.isDelete( po.getIsDelete() );
        msgVO.isRead( po.getIsRead() );
        msgVO.msgId( po.getMsgId() );
        msgVO.msgContent( po.getMsgContent() );
        msgVO.msgType( po.getMsgType() );
        msgVO.receiverId( po.getReceiverId() );
        msgVO.senderId( po.getSenderId() );

        return msgVO.build();
    }

    @Override
    public List<MsgVO> msgList2VO(List<Msg> vo) {
        if ( vo == null ) {
            return null;
        }

        List<MsgVO> list = new ArrayList<MsgVO>( vo.size() );
        for ( Msg msg : vo ) {
            list.add( msg2VO( msg ) );
        }

        return list;
    }

    @Override
    public RankVO rank2VO(Rank po) {
        if ( po == null ) {
            return null;
        }

        RankVO.RankVOBuilder rankVO = RankVO.builder();

        rankVO.rankId( po.getRankId() );
        rankVO.productId( po.getProductId() );
        rankVO.rankName( po.getRankName() );
        rankVO.rankPosition( po.getRankPosition() );
        rankVO.rankScore( po.getRankScore() );
        rankVO.userId( po.getUserId() );
        rankVO.storyIds( po.getStoryIds() );

        return rankVO.build();
    }

    @Override
    public List<RankVO> rankList2VO(List<Rank> vo) {
        if ( vo == null ) {
            return null;
        }

        List<RankVO> list = new ArrayList<RankVO>( vo.size() );
        for ( Rank rank : vo ) {
            list.add( rank2VO( rank ) );
        }

        return list;
    }
}
