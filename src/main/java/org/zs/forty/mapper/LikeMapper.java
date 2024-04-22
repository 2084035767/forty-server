package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.entity.Like;
import org.zs.forty.model.vo.LikeVO;

@Mapper
public interface LikeMapper {
  List<Like> selectAll();
  
  LikeVO selectByLikeId(Long LikeId);
  
  List<Like> selectByUserId(Long userId);
  
  List<Like> selectByStoryId(Long storyId);
  
  Long insert(LikeDTO likeDTO);
  
  int deleteById(Long LikeId);
  
  int updateById(LikeDTO likeDTO);
}