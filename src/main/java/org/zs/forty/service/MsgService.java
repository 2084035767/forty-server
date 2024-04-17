package org.zs.forty.service;

import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;
import org.zs.forty.model.vo.MsgVO;

import java.util.List;

public interface MsgService {
    List<Msg> selectMsgById(Long msgid);
    MsgVO addMsg(MsgDTO msgDTO);
    Boolean updateMsg(MsgDTO msgDTO);
    Boolean deleteMsgById(Long msgid);
}
