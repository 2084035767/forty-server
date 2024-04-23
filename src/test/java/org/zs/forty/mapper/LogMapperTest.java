package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;

@SpringBootTest
class LogMapperTest {
    @Resource
    private LogMapper logMapper;
    @Test
    void selectByLogId(){
        LogVO log = logMapper.selectByLogId(1L);
//        System.out.println(log);
        assert log != null;
    }
    @Test
    void deleteByLogId(){
        logMapper.delete(1L);

    }
    @Test
    void add(){
        Long log = logMapper.add(
                LogDTO.builder()
                        .logName("ssss")
                        .message("SSSSSSSSSS")
                        .userId(9L)
                        .logLevel(1)
                        .build());
        assert  log != null;

    }
    @Test
    void update(){
        logMapper.update(
                LogDTO.builder()
                        .logId(1L)
                        .logName("Tang Sze Yu")
                        .build()//Tang Sze Yu
        );
    }

}
