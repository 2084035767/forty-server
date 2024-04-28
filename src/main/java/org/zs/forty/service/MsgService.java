package org.zs.forty.service;

import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;

import java.util.List;

public interface MsgService {
    MsgVO selectMsgById(Long msgId);
    MsgVO addMsg(MsgDTO msgDTO);
    Boolean updateMsg(MsgDTO msgDTO);
    Boolean deleteMsgById(Long msgId);
    List<MsgVO> selectMsgByUId(Long receiverId,int msgType);
}
