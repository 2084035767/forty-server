package org.zs.forty.service;

import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;

public interface LikeService {
    List<LikeVO> findByLikeId (Long likeId, PageDTO pageDTO);
    LikeVO insert(LikeDTO likeDTO);
    LikeVO findByUserID(Long userid);
    LikeVO findByStoryId(Long storyId);
    Boolean deleteById(Long isDelete);
    LikeVO delete(Long likeId);
    LikeVO update(LikeDTO likeDTO);
}
