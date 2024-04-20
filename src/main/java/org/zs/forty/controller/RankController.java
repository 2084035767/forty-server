package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.RankDTO;
import org.zs.forty.model.vo.RankVO;
import org.zs.forty.service.RankService;

@Tag(name = "排行榜管理")
@RequestMapping("/api/rank")
@RestController
public class RankController {
    @Resource private RankService rankService;
    @Operation(summary = "删除排行榜信息")
    @DeleteMapping("/{rankId}")
    public Boolean delete(@Valid @NotNull @PathVariable Long rankId) {
        return rankService.delete(rankId);
    }
    @Operation(summary = "更新排行榜")
    @PutMapping
    public Boolean update(@Valid @RequestBody RankDTO rankDTO) {
        return rankService.update(rankDTO);
    }
    @Operation(summary = "添加排行榜信息")
    @PostMapping
    public RankVO insert(@Valid @RequestBody RankDTO rankDTO) {
        return rankService.insert(rankDTO);
    }
    @Operation(summary = "获取排行榜列表")
    @PostMapping("/{rankId}")
    public RankVO selectByRankId(@Valid @NotNull @PathVariable("rankId") Long rankId) {
        return rankService.selectByRankId(rankId);
    }
}
