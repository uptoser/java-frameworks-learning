package com.uptoser.ssm.mybatis.c2.config.pojo;
/**
 * MyBatis对数据库的Blob字段也进行了支持，它提供了一个BlobTypeHandler，
 * 为了应付更多的场景，它还提供了 ByteArrayTypeHandler，只是它不太常用
 */
public class TestFile {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestFile{" +
                "str='" + str + '\'' +
                '}';
    }
}
