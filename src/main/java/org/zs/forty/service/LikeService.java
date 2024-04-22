package org.zs.forty.service;

import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

public interface LikeService {
    LikeVO findById(Long likeId);
    LikeVO findByUserId(Long userId);
    LikeVO findByStoryId(Long storyId);
    LikeVO insert(LikeDTO likeDTO);
    Boolean deleteById(Long likeId);
    Boolean update(LikeDTO likeDTO);


}
