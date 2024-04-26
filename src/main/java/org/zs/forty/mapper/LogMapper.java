package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;

public interface LogMapper extends BaseMapper<LogVO> {
  LogVO selectByLogId(Long logId);
  
  Long add(LogDTO logDTO);
  
  int update(LogDTO logDTO);
  
  int delete(Long logId);
}