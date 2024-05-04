package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;
import org.zs.forty.model.vo.MsgVO;

@Mapper
public interface MsgMapper extends BaseMapper<Msg> {
  // List<MsgVO> selectAllMsgs();
  MsgVO selectMsgById(Long msgId);
  
  List<MsgVO> selectMsgByUId(Long receiverId, int msgType);
  
  Long add(MsgDTO msgDTO);
  
  int update(MsgDTO msgDTO);
  
  int deleteMsgById(Long msgId);
}