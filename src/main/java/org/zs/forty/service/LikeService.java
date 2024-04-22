package org.zs.forty.service;

import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;

public interface LikeService {
    LikeVO findById(Long likeId);
    List<LikeVO> findByUserId(Long userId);
    List<LikeVO> findByStoryId(Long storyId);
    LikeVO insert(LikeDTO likeDTO);
    Boolean deleteById(Long likeId);
    Boolean update(LikeDTO likeDTO);


}
