package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;
import org.zs.forty.model.vo.MsgVO;

@Mapper
public interface MsgMapper extends BaseMapper<Msg> {
    MsgVO selectMsgById(Long msgId);
    Long add(MsgDTO msgDTO);
    int update(MsgDTO msgDTO);
    int deleteMsgById(Long msgId);
}
