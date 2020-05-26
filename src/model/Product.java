package model;

public class Product {
    private int id ;
    private String productName;
    private Float Price;
    private  int Quantity;
    private String color;
    private String Category;

    public Product() {
    }

    public Product(int id, String productName, Float price, int quantity, String color, String category) {
        this.id = id;
        this.productName = productName;
        Price = price;
        Quantity = quantity;
        this.color = color;
        Category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
