package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface iProduct {
    List<Product> findAll() throws SQLException;

    void insertProduct(Product product) throws SQLException;

    Product getProductById(int id) throws SQLException;

    boolean updateProduct(Product product) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;
    List<Product> searchProduct(String name) throws SQLException;
}
