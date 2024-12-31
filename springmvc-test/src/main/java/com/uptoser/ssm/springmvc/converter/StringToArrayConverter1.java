package com.uptoser.ssm.springmvc.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Set;

/**
 * GenericConverter，它能够满足数组和集合转换的要求，这是一个比较底层的接口，
 * 为了进行类型匹配判断，还定义了另外一个接口，这个接口就是ConditionalConverter
 * 整合原有的接口GenericConverter，有了一个新的接口ConditionalGenericConverter，
 * 它是最常用的集合转换器接口，既能判断，又能转换
 *
 * Spring Core 开发了不少的实现类，这些实现类都会注册到ConversionService对象里，
 * 通过ConditionalConverter 的matches进行匹配。
 * 如果可以匹配，则会调用convert方法进行转换，它能够提供各种对数组和集合的转换。
 *
 */
public class StringToArrayConverter1 implements ConditionalGenericConverter {


    @Override
    public boolean matches(TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {

        return false;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return null;
    }

    @Override
    public Object convert(Object o, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        return null;
    }
}
