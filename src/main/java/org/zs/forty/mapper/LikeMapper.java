package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

@Mapper
public interface LikeMapper {

   LikeVO selectByLikeId(Long likeId);
   LikeVO selectByUserId(Long userId);
   LikeVO selectByStoryId(Long storyId);
   LikeVO insert(LikeDTO likeDTO);
   Boolean deleteById(Long LikeId);
   Boolean updateById(LikeDTO likeDTO);



}
