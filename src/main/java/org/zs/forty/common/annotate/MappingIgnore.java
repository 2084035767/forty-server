package org.zs.forty.common.annotate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description: 实体映射忽略
 **/

@Retention(RetentionPolicy.CLASS)
@Mappings(value = {
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createTime", ignore = true),
    @Mapping(target = "updateTime", ignore = true)
})
public @interface MappingIgnore {
}