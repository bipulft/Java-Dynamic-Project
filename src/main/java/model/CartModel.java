package model;
import model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.Part;

public class CartModel {
    private ProductModel product;
    private String product_quantity;
    

    public CartModel(ProductModel product, String product_quantity) {
        this.product = product;
        this.product_quantity = product_quantity;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
}
