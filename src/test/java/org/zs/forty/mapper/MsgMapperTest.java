package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;

@SpringBootTest
public class MsgMapperTest {
    @Resource private MsgMapper mapper;
    @Test
    void selectMsgById(){
        Msg msg = mapper.selectMsgById(1L);
        assert msg != null;
    }
    @Test
    void update(){
        int test = mapper.update(
                MsgDTO.builder()
                        .msgid(5)
                        .msgType(0)
                        .build()
        );
    }

}
