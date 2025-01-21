package com.uptoser.ssm.dubbo.spi;

public class MysqlDriver implements Driver {
    @Override
    public String connect() {
        return "连接Mysql数据库";
    }
}
