package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImp implements iProduct {
    private String URL = "jdbc:mysql://localhost:3306/product";
    private String name = "root";
    private String password = "";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String INSERT_INTO_PRODUCT = "insert into Product(id,ProductName,Price,Quantity,Color,Category) values (?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID = "select * from Product where id = ?";
    private static final String UPDATE_PRODUCT_BY_ID = "UPDATE Product set ProductName = ?, Price = ?,Quantity = ?,Color =? ,Category = ? where id = ?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE from Product where id = ?";

    public ProductImp() {

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, name, password);
        return connection;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ProductName");
                Float price = resultSet.getFloat("Price");
                int quantity = resultSet.getInt("Quantity");
                String color = resultSet.getString("Color");
                String category = resultSet.getString("Category");
                Product product = new Product(id, name, price, quantity, color, category);
                list.add(product);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        Product product = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String name = resultSet.getString("ProductName");
                float price = resultSet.getFloat("Price");
                int quantity = resultSet.getInt("Quantity");
                String color = resultSet.getString("Color");
                String category = resultSet.getString("Category");
                product = new Product(Id, name, price, quantity, color, category);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setInt(6, product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Product> searchProduct(String name) throws SQLException {
        List<Product> getProduct = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "{call getProduct(?)}";
            CallableStatement callableStatement = connection.prepareCall(sql);
            String name1 = "%" + name + "%";
            callableStatement.setString(1, name1);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name2 = resultSet.getString("ProductName");
                float price = resultSet.getFloat("Price");
                int quantity = resultSet.getInt("Quantity");
                String color = resultSet.getString("Color");
                String category = resultSet.getString("Category");
                getProduct.add(new Product(id, name2, price, quantity, color, category));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return getProduct;
    }
}
