package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        int menuId = item.getMenuId();
        if (items.containsKey(menuId)) {
            CartItem existingItem = items.get(menuId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(menuId, item);
        }
    }

    public void updateItem(int menuId, int quantity) {
        if (items.containsKey(menuId)) {
            CartItem item = items.get(menuId);
            item.setQuantity(quantity);
        }
    }

    public void removeItem(int menuId) {
        items.remove(menuId);
    }
}
