package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.vo.RankVO;

@SpringBootTest
class RankMapperTest {
    @Resource
    private RankMapper rankMapper;
    @Test
    void selectByRankId(){
        RankVO rank = rankMapper.selectByRankId(1L);
        assert rank !=null;
    }

}
