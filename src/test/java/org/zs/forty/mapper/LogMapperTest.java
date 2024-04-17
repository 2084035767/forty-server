package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.entity.Log;

@SpringBootTest
class LogMapperTest {
    @Resource
    private LogMapper logMapper;
    @Test
    void selectByLogId(){
        Log log = logMapper.selectByLogId(1L);
        System.out.println(log);
        assert log != null;
    }
    @Test
    void deleteByLogId(){



    }
    @Test
    @Transactional
    void add(){
        Long log = logMapper.add(
                LogDTO.builder()
                        .logName("ssss")
                        .message("SSSSSSSSSS")
                        .userid(9L)
                        .build());
        assert  log != null;

    }
    @Test
    void update(){
//        LogDTO logDTO = new LogDTO();
//        logDTO.setLogid(5);
//        logDTO.setLogLevel(1);
//        logDTO.setLogName("Paul Davis");
//        logDTO.setMessage("To successfully establish a new connection to local/remote server - no matter via");
//        logDTO.setUserid(9);
//        int result = logMapper.update(logDTO);
//        System.out.println(result);
    }

}
