package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.LogMapper;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.entity.Log;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.service.LogService;
@Slf4j
@Service
@MappingIgnore
public class LogServiceImpl implements LogService {
    @Resource private LogMapper logMapper;
    @Resource private MainMapper mainMapper;
    @Override public LogVO findByLogId(Long logid) {
        Log log = logMapper.selectByLogId(logid);
        return mainMapper.log2VO(log);
    }

    @Override public LogVO addLog(LogDTO logDTO) {
        return mainMapper.log2VO(logMapper.selectById(logMapper.add(logDTO)));
    }

    @Override public Boolean updateLog(LogDTO logDTO) {
        return logMapper.update(logDTO) > 0;
    }

    @Override public Boolean deletealog(Long logid) {
        return logMapper.delete(logid) > 0;
    }
}
