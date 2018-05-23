package info.thecodinglive.model;

public class Product {
    private String color;
    private String productName;
    private int price;

    public Product() {
    }

    public Product(String color, String productName, int price) {
        this.color = color;
        this.productName = productName;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
