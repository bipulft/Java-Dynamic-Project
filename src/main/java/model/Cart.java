package model;
import model.ProductModel;

import java.util.ArrayList;

import model.ProductModel;
import java.util.List;

import controller.database.DatabaseController;

public class Cart {
	 private List<CartModel> items;


public Cart() {
    items = new ArrayList<CartModel>();
}
DatabaseController dbController = new DatabaseController();

//add a product to the cart
public void addItem(String productId, String product_quantity) {
    
    ProductModel product = dbController.getProductById(productId);
    if (product != null) {
        CartModel cartModel = new CartModel(product, product_quantity);
        items.add(cartModel);
    }
}
//remove a product from the cart
public void removeItem(String productId) {
    CartModel cartItemToRemove = null;
    for (CartModel cartModel : items) {
        if (cartModel.getProduct().getProduct_id().equals(productId)) {
            cartItemToRemove = cartModel;
            break;
        }
    }
    if (cartItemToRemove != null) {
        items.remove(cartItemToRemove);
    }
}

// update the quantity of a product in the cart
public void updateItem(String productId, String product_quantity) {
    for (CartModel cartModel : items) {
        if (cartModel.getProduct().getProduct_id().equals(productId)) {
            cartModel.setProduct_quantity(product_quantity);
            break;
        }
    }
}

//get the total price of all items in the cart
public String getTotalPrice() {
    double totalPrice = 0.0; // Initialize totalPrice as double
    for (CartModel cartModel : items) {
        ProductModel product = cartModel.getProduct();
        if (product != null) {
            double unit_price = Double.parseDouble(product.getUnit_price());
            int product_quantity = Integer.parseInt(cartModel.getProduct_quantity());
            totalPrice += unit_price * product_quantity;
        }
    }
    System.out.println("Total Price: " + totalPrice); // Log the total price
    return String.valueOf(totalPrice); // Convert totalPrice to String for return
}

// get all items in the cart
public List<CartModel> getItems() {
    return items;
}

public void clear() {
    items.clear();
}

}
