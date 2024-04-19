package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.entity.Log;
@Mapper
public interface LogMapper extends BaseMapper<Log> {
    Log selectByLogId(Long logid);
    Long add(LogDTO logDTO);
    int update(LogDTO logDTO);
    int delete(Long logid);



}
