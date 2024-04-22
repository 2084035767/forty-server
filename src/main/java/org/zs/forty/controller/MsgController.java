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
import org.zs.forty.model.dto.MsgDTO;
import org.zs.forty.model.vo.MsgVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.service.MsgService;

@Tag(name = "通知管理")
@RequestMapping("/api/msg")
@RestController
public class MsgController {
  @Resource private MsgService msgService;
  
  @Operation(summary = "获取通知列表")
  @GetMapping("/{msgId}")
  public MsgVO selectMsgById(@Valid @NotNull @PathVariable("msgId") Long msgId) {
    return msgService.selectMsgById(msgId);
  }
  
  @Operation(summary = "添加通知")
  @PostMapping
  public MsgVO addMsg(@Valid @RequestBody MsgDTO msgDTO) {
    return msgService.addMsg(msgDTO);
  }
  
  @Operation(summary = "更新通知")
  @PutMapping
  public ResultVO updateMsg(@Valid @RequestBody MsgDTO msgDTO) {
    return msgService.updateMsg(msgDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "删除通知")
  @DeleteMapping("/{msgId}")
  public ResultVO deleteMsgById(@Valid @NotNull @PathVariable Long msgId) {
    return msgService.deleteMsgById(msgId) ? ResultVO.success() : ResultVO.error();
  }
}