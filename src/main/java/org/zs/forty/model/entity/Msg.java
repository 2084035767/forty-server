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
        @TableId(value = "id", type = IdType.AUTO)
        private long isArchive;
        /**
         * 是否删除=0否 1是
         */
        private long isDelete;
        /**
         * 是否已读=0否 1是
         */
        private long isRead;
        /**
         * 消息内容
         */
        private String msgContent;
        private long msgid;
        /**
         * 消息的类型 0系统通知，1私信
         */
        private long msgType;
        /**
         * 接收者
         */
        private long receiverid;
        /**
         * 发送者
         */
        private long senderid;
        /**
         * 更新时间
         */
        @TableField(value = "create_time", fill = FieldFill.INSERT)
        protected LocalDateTime createTime;
        @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
        protected LocalDateTime updateTime;

    }

