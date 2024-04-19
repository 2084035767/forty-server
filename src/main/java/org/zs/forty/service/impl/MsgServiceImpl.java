package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.MsgMapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;
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
    public List<Msg> selectMsgById(Long msgid) {
        Msg msg = msgMapper.selectMsgById(msgid);
        return (List<Msg>) mainMapper.msg2VO(msg);
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
    public Boolean deleteMsgById(Long msgid) {
        return msgMapper.deleteMsgById(msgid) > 0;
    }
}
