package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.mapstruct.MainMapper;
import org.zs.forty.mapper.MsgMapper;
import org.zs.forty.model.dto.MsgConditionDTO;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;
import org.zs.forty.service.MsgService;

@Slf4j
@Service
@MappingIgnore
@CacheConfig(cacheNames = "MsgService")
public class MsgServiceImpl implements MsgService {
  @Resource private MainMapper mainMapper;
  @Resource private MsgMapper msgMapper;
  
  @Override
  @Cacheable(key = "#msgId")
  public MsgVO selectMsgById(Long msgId) {
    return msgMapper.selectMsgById(msgId);
  }
  
  @Override
  @Cacheable(key = "#msgDTO.msgId")
  public MsgVO addMsg(MsgDTO msgDTO) {
    return mainMapper.msg2VO(msgMapper.selectById(msgMapper.add(msgDTO)));
  }
  
  @Override
  @CachePut(key = "#msgDTO.msgId")
  public Boolean updateMsg(MsgDTO msgDTO) {
    return msgMapper.update(msgDTO) > 0;
  }
  
  @Override
  @CacheEvict(key = "#msgId")
  public Boolean deleteMsgById(Long msgId) {
    return msgMapper.deleteMsgById(msgId) > 0;
  }
  
  @Override
  public List<MsgVO> selectMsgByUId(MsgConditionDTO msgCondition) {
    return
        msgMapper.selectMsgByUId(msgCondition.getReceiverId(), msgCondition.getMsgType());
  }
}