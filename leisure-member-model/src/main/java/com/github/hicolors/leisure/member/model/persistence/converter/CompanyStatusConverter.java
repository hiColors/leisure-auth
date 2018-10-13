package com.github.hicolors.leisure.member.model.persistence.converter;

import com.github.hicolors.leisure.member.model.consts.EnumCompanyStatus;

import javax.persistence.AttributeConverter;

public class CompanyStatusConverter implements AttributeConverter<EnumCompanyStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EnumCompanyStatus attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public EnumCompanyStatus convertToEntityAttribute(Integer dbData) {
        //将数字转换为描述
        for (EnumCompanyStatus type : EnumCompanyStatus.values()) {
            if (dbData.equals(type.getValue())) {
                return type;
            }
        }
        throw new RuntimeException("Unknown database value: " + dbData);
    }
}