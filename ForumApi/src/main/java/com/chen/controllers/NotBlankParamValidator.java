package com.chen.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;

public class NotBlankParamValidator implements ParamValidator {


    @Override
    public boolean supports(ParamMetaData metaData) {
        return metaData.getAnnotation(NotBlank.class) != null;
    }

    @Override
    public Object validate(ParamMetaData metaData, Invocation invocation, Object target, Errors errors) {
        String paramName = metaData.getParamName();
        String value = invocation.getParameter(paramName);
        if (StringUtils.isBlank(value)) {
            return "@参数不能为空";
        }
        return null;
    }
}