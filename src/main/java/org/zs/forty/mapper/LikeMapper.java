package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;

@Mapper
public interface LikeMapper {

   LikeVO selectByLikeId(Long likeId);
   List<LikeVO> selectByUserId(Long userId);
   List<LikeVO> selectByStoryId(Long storyId);
   Long insert(LikeDTO likeDTO);
   int deleteById(Long LikeId);
  int update(LikeDTO likeDTO);



}
