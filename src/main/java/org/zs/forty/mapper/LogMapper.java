package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;

import java.util.List;

@Mapper
public interface LogMapper extends BaseMapper<LogVO> {
  List<LogVO> selectAllLogs();
  LogVO selectByLogId(Long logId);
  
  Long add(LogDTO logDTO);
  
  int update(LogDTO logDTO);
  
  int delete(Long logId);
}