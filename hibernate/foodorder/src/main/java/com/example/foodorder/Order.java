package com.example.foodorder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int orderId;
    private String customerName;
    private String foodItem;
    private int quantity;
    private double totalAmount;
    private String orderDate;
    private String orderStatus;

    public Order() {
    }

    public Order(int orderId, String customerName, String foodItem,
                 int quantity, double totalAmount,
                 String orderDate, String orderStatus) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "\nOrder ID : " + orderId +
               "\nCustomer Name : " + customerName +
               "\nFood Item : " + foodItem +
               "\nQuantity : " + quantity +
               "\nTotal Amount : " + totalAmount +
               "\nOrder Date : " + orderDate +
               "\nOrder Status : " + orderStatus;
    }
}