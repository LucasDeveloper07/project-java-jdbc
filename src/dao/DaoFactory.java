package dao;

import daoImpl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {

    public static SellerDao creatSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
