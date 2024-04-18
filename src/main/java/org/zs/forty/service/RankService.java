package org.zs.forty.service;

import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.vo.RankVO;

public interface RankService {
    Boolean delete(Long rankId);
    Boolean update(RankDTO rankDTO);
    RankVO insert(RankDTO rankDTO);

    RankVO selectByRankId(Long rankId);
}
