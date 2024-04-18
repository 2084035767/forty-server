package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.RankMapper;
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.vo.RankVO;
import org.zs.forty.service.RankService;

@Slf4j
@Service
@MappingIgnore
public class RankServiceImpl implements RankService {
    @Resource private MainMapper mainMapper;
    @Resource private RankMapper rankMapper;

    @Override
    public Boolean delete(Long rankId) {
        return rankMapper.delete(rankId) >0;
    }

    @Override
    public Boolean update(RankDTO rankDTO) {
        return rankMapper.update(rankDTO) > 0;
    }

    @Override
    public RankVO insert(RankDTO rankDTO) {
        return mainMapper.rank2VO(rankMapper.selectById(rankMapper.insert(rankDTO)));
    }

    @Override
    public RankVO selectByRankId(Long rankId) {
        return rankMapper.selectByRankId(rankId);
    }
}
