package com.uptoser.ssm.dubbo;


import com.uptoser.ssm.api.dubbo.IDubboService;

public class DubboServiceImpl implements IDubboService {

    @Override
    public String getMessage(String text) {
        System.out.println("receive request data:"+text);
        return text;
    }
}
