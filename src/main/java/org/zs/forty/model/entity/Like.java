package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Like {
  // 主键映射
  @TableId(value = "like_id", type = IdType.AUTO)
  private Long likeId;
  private Long userId;
  private Long storyId;
  private Boolean isDelete;
}