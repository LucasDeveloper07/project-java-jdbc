package dao;

import daoImpl.DepartmentDaoJDBC;
import daoImpl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {

    public static SellerDao creatSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
