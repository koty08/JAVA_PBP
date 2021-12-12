package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private Order.PickUp delivery;

    private static int orderCounter = 1;
    private int orderNo ;

    public Order(){
        orderNo = orderCounter;
        orderCounter++;
    }

    public void completed() {
        delivery.handle(this);
    }

    @Override
    public String toString() {
        return "주문번호: "+orderNo+" - "+items+"\n";
    }

    public void setPickUp(PickUp pickUp) {
        delivery = pickUp;
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public int getOrderNo(){
        return orderNo;
    }

    public static interface PickUp {
        public abstract void handle(Order o);
    }
}