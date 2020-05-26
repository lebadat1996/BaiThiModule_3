package controller;

import model.Product;
import service.ProductImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletProduct", urlPatterns = "/product")
public class ServletProduct extends HttpServlet {
    ProductImp productImp = new ProductImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                try {
                    insetProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "find":
                try {
                    search(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatProduct(request, response);
                break;
            case "edit":
                try {
                    showEditProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    getAllProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = productImp.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void insetProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        Product product = new Product(id, name, price, quantity, color, category);
        productImp.insertProduct(product);
        request.setAttribute("message", "Add Success");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreatProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productImp.getProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        Product product = new Product(id, name, price, quantity, color, category);
        productImp.updateProduct(product);
        request.setAttribute("message1", "Edit Success");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean product = productImp.deleteProduct(id);
        if (product) {
            List<Product> list = productImp.findAll();
            request.setAttribute("productList", list);
            request.setAttribute("title", "Delete Success");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/list.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> product = productImp.searchProduct(name);
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
