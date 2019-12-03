package ua.training.model.dao.impl;

import ua.training.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();


    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

//    @Override
//    public RequestDao createRequestDao() {
//        return new JDBCRequestDao(getConnection());
//    }
//
//    @Override
//    public CommentDao createCommentDao() {
//        return new JDBCCommentDao(getConnection(), createUserDao());
//    }

    @Override
    public BoxDao createBoxDao() {
        return new JDBCBoxDao(getConnection());
    }

    @Override
    public JDBCOrderDao createOrderDao() {
        return new JDBCOrderDao(getConnection());
    }

    @Override
    public ProductDao createProductDao() {
        return new JDBCProductDao(getConnection());
    }

    @Override
    public ProductOrderDao createProductOrderDao() {
        return new JDBCProductOrderDao(getConnection());
    }



    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
