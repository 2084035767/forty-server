package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.entity.Rank;
import org.zs.forty.model.vo.RankVO;

public interface RankMapper extends BaseMapper<Rank> {
  int delete(Long rankId);
  
  int update(RankDTO rankDTO);
  
  Long insert(RankDTO rankDTO);
  
  RankVO selectByRankId(Long rankId);
}