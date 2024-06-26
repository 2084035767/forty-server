package org.zs.forty.mapper;

import java.util.List;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

public interface LikeMapper {
  
  LikeVO selectByLikeId(Long likeId);
  
  List<LikeVO> selectByUserId(Long userId);
  
  List<LikeVO> selectByStoryId(Long storyId);
  
  Long insert(LikeDTO likeDTO);
  
  int deleteById(Long LikeId);
  
  int update(LikeDTO likeDTO);
}