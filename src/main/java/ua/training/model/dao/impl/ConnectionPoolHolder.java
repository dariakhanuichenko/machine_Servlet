package ua.training.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");

                    ds.setUrl("jdbc:mysql://localhost:3306/machine?useTimezone=true&serverTimezone= Europe/Kiev");
                    ds.setUsername("root");
                    ds.setPassword("11111");
                    ds.setMinIdle(5);//минимальное количество простаивающих соединений, которые будут оставаться в пуле
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}