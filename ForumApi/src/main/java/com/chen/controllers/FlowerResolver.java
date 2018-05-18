package com.chen.controllers;

import com.chen.model.Flower;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;

public class FlowerResolver implements ParamResolver {

    @Override
    public Object resolve(Invocation invocation, ParamMetaData metaData) throws Exception {
        for (String paramName : metaData.getParamNames()) {
            if (paramName != null) {
                Flower flower = new Flower();
                String value1 = invocation.getParameter("name");
                String value2 = invocation.getParameter("color");
                String value3s = invocation.getParameter( "id");
                flower.setName(value1);
                flower.setColor(value2);
                int value3 = Integer.parseInt(value3s);
                flower.setId(value3);
                return flower;
            }
        }
        return null;

    }

    @Override
    public boolean supports(ParamMetaData metaData) {
        return Flower.class == metaData.getParamType();
    }

}