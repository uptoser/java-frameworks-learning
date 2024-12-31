package com.uptoser.ssm.springmvc.converter;

import com.uptoser.ssm.springmvc.pojo.Role;
import org.springframework.util.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter是一种一对一的转换器
 */
public class StringToRoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String str) {
        //空串
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        //不包含指定字符
        if (str.indexOf("-") == -1) {
            return null;
        }
        String[] arr = str.split("-");
        //字符串长度不对
        if (arr.length != 3) {
            return null;
        }
        Role role = new Role();
        role.setId(Long.parseLong(arr[0]));
        role.setRoleName(arr[1]);
        role.setNote(arr[2]);
        return role;
    }

}
