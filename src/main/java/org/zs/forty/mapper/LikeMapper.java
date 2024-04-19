package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.entity.Like;
import org.zs.forty.model.vo.LikeVO;

import java.util.List;
@Mapper
public interface LikeMapper {
   List<Like> selectAll();
   List<Like>  selectByLikeId(Long LikeId);
   List<Like> selectByUserId(Long userId);
   List<Like> selectByStoryId(Long storyId);
   Long insert(LikeDTO likeDTO);
   LikeVO deleteById(Long LikeId);
   LikeVO updateById(LikeDTO likeDTO);
}
