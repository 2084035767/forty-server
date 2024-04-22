package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;
@Mapper
public interface LikeMapper {
   List<LikeVO> selectAll();
   List<LikeVO> selectByLikeId(PageDTO pageDTO);
   LikeVO selectByUserId(Long userId);
   LikeVO selectByStoryId(Long storyId);
   LikeVO insert(LikeDTO likeDTO);
   Boolean deleteById(Long LikeId);
   Boolean updateById(LikeDTO likeDTO);



}
