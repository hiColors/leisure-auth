package com.github.hicolors.leisure.member.model.persistence.converter;


import com.github.hicolors.leisure.member.model.consts.EnumPlatformStatus;

import javax.persistence.AttributeConverter;

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
        throw new RuntimeException("unknown database value: " + dbData);
    }
}