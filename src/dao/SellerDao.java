package dao;

import java.util.List;

import entities.Seller;

public interface SellerDao {
    
    void insert(Seller seller);
    void update(Seller seller);
    void deleteById(Seller seller);
    Seller findById(int id);
    List<Seller> findAll();
}
