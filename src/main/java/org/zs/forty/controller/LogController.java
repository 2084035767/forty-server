package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.service.LogService;

@Tag(name = "日志管理")
@RequestMapping("/api/log")
@RestController
public class LogController {
  @Resource private LogService logService;
  
  @Operation(summary = "获取日志列表")
  @GetMapping("/{logId}")
  public LogVO findByLogId(@Valid @NotNull @PathVariable Long logId) {
    return logService.findByLogId(logId);
  }
  
  @Operation(summary = "添加日志信息")
  @PostMapping
  public LogVO addLog(@Valid @RequestBody LogDTO logDTO) {
    return logService.addLog(logDTO);
  }
  
  @Operation(summary = "更新日志信息")
  @PutMapping
  public ResultVO<Object> updateLog(@Valid @RequestBody LogDTO logDTO) {
    return logService.updateLog(logDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "删除日志信息")
  @DeleteMapping("/{logId}")
  public ResultVO<Object> deleteLog(@Valid @NotNull @PathVariable Long logId) {
    return logService.deleteLogByLogId(logId) ? ResultVO.success() : ResultVO.error();
  }
}