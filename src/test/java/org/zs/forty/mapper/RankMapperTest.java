package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.RankDTO;
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
    @Test
    void add(){
        Long test = rankMapper.insert(
                RankDTO.builder()
                        .userId(1L)
                        .rankName("111")
                        .rankPosition(5L)
                        .rankScore(6L)
                        .productId(2L)
                        .storyIds("1,2,3")
                        .build()
        );
    }
    @Test
    void  update(){
        rankMapper.update(
                RankDTO.builder()
                        .rankId(1L)
                        .userId(5L)
                        .build()
        );
    }
    @Test
    void delete(){
        rankMapper.delete(1L);
    }

}
