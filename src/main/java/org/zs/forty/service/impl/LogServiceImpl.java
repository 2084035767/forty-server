package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.mapper.LogMapper;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.service.LogService;

@Slf4j
@Service
public class LogServiceImpl implements LogService {
  @Resource private LogMapper logMapper;
  
  @Override public LogVO findByLogId(Long logId) {
    return logMapper.selectByLogId(logId);
  }
  
  @Override public LogVO addLog(LogDTO logDTO) {
    return logMapper.selectByLogId(logMapper.add(logDTO));
  }
  
  @Override public Boolean updateLog(LogDTO logDTO) {
    return logMapper.update(logDTO) > 0;
  }
  
  @Override public Boolean deleteLogByLogId(Long logId) {
    return logMapper.delete(logId) > 0;
  }
}