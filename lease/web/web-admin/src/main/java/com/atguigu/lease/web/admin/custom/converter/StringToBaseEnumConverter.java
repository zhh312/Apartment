package com.atguigu.lease.web.admin.custom.converter;

import com.atguigu.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToBaseEnumConverter  implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {

            @Override
            public T convert(String source) {
                T[] enums = targetType.getEnumConstants();
                for (T e : enums) {
                    if(e.getCode().equals(Integer.valueOf(source))) {
                        return e;
                    }
                }
                throw new IllegalArgumentException("No enum constant " + targetType.getCanonicalName() + " with code " + source);
            }
        };
    }
}
