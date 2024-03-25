package org.zs.forty.common.annotate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
 **/

@Retention(RetentionPolicy.CLASS)
@Mappings(value = {
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createTime", ignore = true),
    @Mapping(target = "updateTime", ignore = true)
})
public @interface MappingIgnore {
}