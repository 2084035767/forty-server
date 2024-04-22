package org.zs.forty.service;

import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;

public interface LikeService {
    List<LikeVO> findByLikeId ( PageDTO pageDTO);
    LikeVO insert(LikeDTO likeDTO);
    LikeVO findByUserId(Long userId);
    LikeVO findByStoryId(Long storyId);
    Boolean deleteById(Long likeId);
    Boolean update(LikeDTO likeDTO);
}
