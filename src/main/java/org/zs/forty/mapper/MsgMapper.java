package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;
import org.zs.forty.model.vo.MsgVO;

import java.util.List;

@Mapper
public interface MsgMapper extends BaseMapper<Msg> {
    List<MsgVO> selectAllMsgs();
    MsgVO selectMsgById(Long msgId);
    List<Msg> selectMsgByUId(Long receiverId, int msgType);

    Long add(MsgDTO msgDTO);
    int update(MsgDTO msgDTO);
    int deleteMsgById(Long msgId);
}
