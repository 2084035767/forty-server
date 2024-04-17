package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.LogDTO;
import org.zs.forty.model.vo.LogVO;
import org.zs.forty.service.LogService;

@Tag(name = "日志管理")
@RequestMapping("/api/log")
@RestController
public class LogController {
    @Resource private LogService logService;
    @Operation(summary = "获取日志列表")
    @PostMapping("/findByLogId/{logid}")
    public LogVO findByLogId(@Valid @NotNull @PathVariable("logid") Long logid){
        return logService.findByLogId(logid);
    }
    @Operation(summary = "添加日志信息")
    @PostMapping("/addLog")
    public LogVO addLog(@Valid @RequestBody LogDTO logDTO) {
        return logService.addLog(logDTO);
    }
    @Operation(summary = "更新日志信息")
    @PutMapping("/updateLog")
    public Boolean updateLog(@Valid @RequestBody LogDTO logDTO) {
        return logService.updateLog(logDTO);
    }
    @Operation(summary = "删除日志信息")
    @DeleteMapping("/deleteLog/{logid}")
    public Boolean deletealog(@Valid @NotNull @PathVariable("logid") Long logid) {
        return logService.deletealog(logid);
    }

}
