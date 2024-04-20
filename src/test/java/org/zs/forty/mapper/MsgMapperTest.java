package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;

@SpringBootTest
public class MsgMapperTest {
    @Resource private MsgMapper msgmapper;
    @Test
    void selectMsgById(){
        MsgVO msg = msgmapper.selectMsgById(1L);
        assert msg != null;
    }
    @Test
    void update(){
        int test = msgmapper.update(
                MsgDTO.builder()
                        .msgId(1L)
                        .msgType(1)
                        .build()
        );
    }
    @Test
    void add(){
        Long test = msgmapper.add(
                MsgDTO.builder()
                        .receiverId(6L)
                        .senderId(5L)
                        .msgContent("ddddd")
                        .msgType(1)
                        .build()
        );}
    @Test
    void delete(){
        msgmapper.deleteMsgById(1L);
    }

}
