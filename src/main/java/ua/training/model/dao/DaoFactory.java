package ua.training.model.dao;

import ua.training.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private volatile static DaoFactory daoFactory;
    public abstract UserDao createUserDao();
    public abstract BoxDao createBoxDao();
    public abstract OrderDao createOrderDao();
    public abstract ProductDao createProductDao();
    public abstract ProductOrderDao createProductOrderDao();



    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
