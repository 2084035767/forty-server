package org.zs.forty.service;

import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

public interface LikeService {
  LikeVO findByLikeId(Long likeId);
  
  LikeVO insert(LikeDTO likeDTO);
  
  LikeVO findByUserId(Long userid);
  
  LikeVO findByStoryId(Long storyId);
  
  Boolean deleteById(Long likeId);
  
  Boolean update(LikeDTO likeDTO);
}