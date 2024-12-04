package com.uptoser.ssm.mybatis.c2.config.transaction_factory;

import com.uptoser.ssm.mybatis.c2.config.type_handler.MyTypeHandler;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 自定义事务工厂
 */
public class MyTransactionFactory implements TransactionFactory {
    Logger logger = Logger.getLogger(MyTransactionFactory.class);

    @Override
    public Transaction newTransaction(Connection conn) {
        return new MyTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new MyTransaction(dataSource,level,autoCommit);
    }
}