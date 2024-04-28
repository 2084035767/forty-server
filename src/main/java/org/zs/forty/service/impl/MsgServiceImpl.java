package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.MsgMapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;
import org.zs.forty.service.MsgService;

import java.util.List;

@Slf4j
@Service
@MappingIgnore
public class MsgServiceImpl implements MsgService {
    @Resource private MainMapper mainMapper;
    @Resource private MsgMapper msgMapper;
    @Override
    public MsgVO selectMsgById(Long msgId) {
        return  msgMapper.selectMsgById(msgId);
    }

    @Override
    public MsgVO addMsg(MsgDTO msgDTO) {
        return mainMapper.msg2VO(msgMapper.selectById(msgMapper.add(msgDTO)));
    }

    @Override
    public Boolean updateMsg(MsgDTO msgDTO) {
        return msgMapper.update(msgDTO) > 0;
    }

    @Override
    public Boolean deleteMsgById(Long msgId) {
        return msgMapper.deleteMsgById(msgId) > 0;
    }

    @Override
    public List<MsgVO> selectMsgByUId(Long receiverId, int msgType) {
        return mainMapper.msgList2VO(msgMapper.selectMsgByUId(receiverId,msgType));
    }
}
