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
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.vo.RankVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.service.RankService;

@Tag(name = "排行榜管理")
@RequestMapping("/api/rank")
@RestController
public class RankController {
  @Resource private RankService rankService;
  
  @Operation(summary = "删除排行榜信息")
  @DeleteMapping("/{rankId}")
  public ResultVO delete(@Valid @NotNull @PathVariable Long rankId) {
    return rankService.delete(rankId) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "更新排行榜")
  @PutMapping
  public ResultVO update(@Valid @RequestBody RankDTO rankDTO) {
    return rankService.update(rankDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "添加排行榜信息")
  @PostMapping
  public RankVO insert(@Valid @RequestBody RankDTO rankDTO) {
    return rankService.insert(rankDTO);
  }
  
  @Operation(summary = "获取排行榜列表")
  @GetMapping("/{rankId}")
  public RankVO selectByRankId(@Valid @NotNull @PathVariable("rankId") Long rankId) {
    return rankService.selectByRankId(rankId);
  }
}