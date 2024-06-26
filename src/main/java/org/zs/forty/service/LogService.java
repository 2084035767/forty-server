package org.zs.forty.service;

import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;

public interface LogService {

  LogVO findByLogId(Long logId);
  
  LogVO addLog(LogDTO logDTO);
  
  Boolean updateLog(LogDTO logDTO);
  
  Boolean deleteLogByLogId(Long logId);
}