package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.MsgConditionDTO;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;

public interface MsgService {
  MsgVO selectMsgById(Long msgId);
  
  MsgVO addMsg(MsgDTO msgDTO);
  
  Boolean updateMsg(MsgDTO msgDTO);
  
  Boolean deleteMsgById(Long msgId);
  
  List<MsgVO> selectMsgByUId(MsgConditionDTO msgConditionDTO);
}