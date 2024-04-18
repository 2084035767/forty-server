package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;

@SpringBootTest
public class MsgMapperTest {
    @Resource private MsgMapper mapper;
    @Test
    void selectMsgById(){
        MsgVO msg = mapper.selectMsgById(1L);
        assert msg != null;
    }
    @Test
    void update(){
        int test = mapper.update(
                MsgDTO.builder()
                        .msgId(5L)
                        .msgType(0L)
                        .build()
        );
    }

}
