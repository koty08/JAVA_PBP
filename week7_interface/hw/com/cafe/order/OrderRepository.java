package com.cafe.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Iterator<Order> {
    List<Order> orders = new ArrayList<>();
    private int nextIdx = 0;

    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        String header = String.format("--- 주문 관리자 화면 ---\n현재 주문수는 총 %d 입니다.\n\n< 주문 내역 >\n", orders.size()-nextIdx);
        String content = "";
        for(int i = nextIdx; i<orders.size(); i++){
            Order order = orders.get(i);
            content += order.toString();
        }
        return header+content+"\n";
    }

    @Override
    public boolean hasNext() {
        return nextIdx < orders.size();
    }

    @Override
    public Order next() {
        return orders.get(nextIdx++);
    }
}
