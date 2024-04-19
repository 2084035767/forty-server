package org.zs.forty.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.entity.Rank;
import org.zs.forty.model.vo.RankVO;

public interface RankService {
    Boolean delete(Long rankid);
    Boolean update(RankDTO rankDTO);
    RankVO insert(RankDTO rankDTO);

    RankVO selectByRankId(Long rankid);
}
