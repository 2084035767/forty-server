package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
        @TableId(value = "msg_id", type = IdType.AUTO)
        private Long msgId;
        private Boolean isArchive;
        private Boolean isDelete;
        private Boolean isRead;
        private String msgContent;
        private Long msgType;
        private Long receiverId;
        private Long senderId;
        @TableField(value = "create_time", fill = FieldFill.INSERT)
        protected LocalDateTime createTime;
        @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
        protected LocalDateTime updateTime;

    }

