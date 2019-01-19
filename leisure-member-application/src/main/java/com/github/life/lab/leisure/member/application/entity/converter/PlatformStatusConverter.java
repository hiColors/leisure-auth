package com.github.life.lab.leisure.member.application.entity.converter;


import com.github.life.lab.leisure.member.application.entity.enums.EnumPlatformStatus;

import javax.persistence.AttributeConverter;

/**
 * PlatformStatusConverter
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @since 2018/10/22
 */
public class PlatformStatusConverter implements AttributeConverter<EnumPlatformStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumPlatformStatus attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public EnumPlatformStatus convertToEntityAttribute(Integer dbData) {
        //将数字转换为描述
        for (EnumPlatformStatus type : EnumPlatformStatus.values()) {
            if (dbData.equals(type.getValue())) {
                return type;
            }
        }
        throw new RuntimeException("PlatformStatusConverter error, unknown database value: " + dbData);
    }
}