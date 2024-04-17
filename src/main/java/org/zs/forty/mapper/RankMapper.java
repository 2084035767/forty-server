package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.entity.Rank;

@Mapper
public interface RankMapper extends BaseMapper<Rank> {
    int delete(Long rankid);
    int update(RankDTO rankDTO);
    Long insert(RankDTO rankDTO);

    Rank selectByRankId(Long rankid);


}
