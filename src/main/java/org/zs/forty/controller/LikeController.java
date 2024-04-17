package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.LikeDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.entity.Like;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.model.vo.ProductVO;
import org.zs.forty.service.LikeService;

@Tag(name="点赞管理")
@RestController
@RequestMapping("/api/relationService")
public class LikeController {
    @Resource private LikeService relationService;
    @Operation(summary = "获取点赞列表")
    @PostMapping("/list")
    public PageInfo<LikeVO> AllLike(@Valid@PathVariable Long LikeService,@Valid @RequestBody PageDTO pageDTO) {
        return new PageInfo<>(relationService.findByLikeId(LikeService,pageDTO));
    }

    @Operation(summary = "添加点赞")
    @PostMapping
    public LikeVO insert(@Valid @RequestBody LikeDTO likeDTO) {
        return relationService.insert(likeDTO);
    }

    @Operation(summary = "删除点赞")
    @PostMapping("/delete")
    public LikeVO insert(@Valid@RequestBody Long likeId){
        return relationService.delete(likeId);
    }

    @Operation(summary = "更新点赞")
    @PostMapping("/update")
    public LikeVO update(@Valid@RequestBody LikeDTO likeDTO){
        return relationService.update(likeDTO);
    }

}
