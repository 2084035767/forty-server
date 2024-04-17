package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;
import org.zs.forty.service.MsgService;

@Tag(name = "通知管理")
@RequestMapping("/api/msg")
@RestController
public class MsgController {
    @Resource private MsgService msgService;
    @Operation(summary = "获取通知列表")
    @GetMapping("/selectMsgById/{msgid}")
    public MsgVO selectMsgById(@Valid  @NotNull @PathVariable("msgid") Long msgid) {
        return (MsgVO) msgService.selectMsgById(msgid);
    }
    @Operation(summary = "添加通知")
    @PostMapping("/addMsg")
    public MsgVO addMsg(@Valid @RequestBody MsgDTO msgDTO) {
        return msgService.addMsg(msgDTO);
    }
    @Operation(summary = "更新通知")
    @PutMapping("/updateMsg")
    public Boolean updateMsg(@Valid @RequestBody MsgDTO msgDTO) {
        return msgService.updateMsg(msgDTO);
    }
    @Operation(summary = "删除通知")
    @DeleteMapping("/deleteMsgById/{msgid}")
    public Boolean deleteMsgById( @Valid @NotNull @PathVariable("msgid") Long msgid) {
        return msgService.deleteMsgById(msgid);
    }
}
