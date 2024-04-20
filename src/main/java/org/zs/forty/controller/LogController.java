package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.service.LogService;

@Tag(name = "日志管理")
@RequestMapping("/api/log")
@RestController
public class LogController {
    @Resource private LogService logService;
    
    @Operation(summary = "获取日志列表")
    @PostMapping("/findByLogId/{logId}")
    public LogVO findByLogId(@Valid @NotNull @PathVariable("logId") Long logId) {
        return logService.findByLogId(logId);
    }
    
    @Operation(summary = "添加日志信息")
    @PostMapping
    public LogVO addLog(@Valid @RequestBody LogDTO logDTO) {
        return logService.addLog(logDTO);
    }
    
    @Operation(summary = "更新日志信息")
    @PutMapping
    public Boolean updateLog(@Valid @RequestBody LogDTO logDTO) {
        return logService.updateLog(logDTO);
    }
    
    @Operation(summary = "删除日志信息")
    @DeleteMapping
    public Boolean deleteLog(@Valid @NotNull Long logId) {
        return logService.deletelog(logId);
    }
}