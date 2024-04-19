package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.entity.Msg;

@Mapper
public interface MsgMapper extends BaseMapper<Msg> {
    Msg selectMsgById(Long msgid);
    Long add(MsgDTO msgDTO);
    int update(MsgDTO msgDTO);
    int deleteMsgById(Long msgid);
}
