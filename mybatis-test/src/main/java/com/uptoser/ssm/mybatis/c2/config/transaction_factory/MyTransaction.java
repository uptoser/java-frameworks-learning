package com.uptoser.ssm.mybatis.c2.config.transaction_factory;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 自义定事务实现类
 * MyBatis 为Transaction 提供了两个实现类：JdbcTransaction 和ManagedTransaction。要实现接口 Transaction
 * 对应着两种工厂：JdbcTransactionFactory和ManagedTransactionFactory。工厂需要实现TransactionFactory接口
 */
public class MyTransaction extends JdbcTransaction implements Transaction {

    public MyTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
        super(ds, desiredLevel, desiredAutoCommit);
    }

    public MyTransaction(Connection connection) {
        super(connection);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public void commit() throws SQLException {
        super.commit();
    }

    @Override
    public void rollback() throws SQLException {
        super.rollback();
    }

    @Override
    public void close() throws SQLException {
        super.close();
    }

    @Override
    public Integer getTimeout() throws SQLException {
        return super.getTimeout();
    }
}
