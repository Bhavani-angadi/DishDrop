package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        int itemId = item.getCartItemId();
        if (items.containsKey(itemId)) {
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemId, item);
        }
    }

    public void updateItem(int cartItemId, int quantity) {
    	if (items.containsKey(cartItemId)) {
            if (quantity <= 0) {
                items.remove(cartItemId);
            } else {
                items.get(cartItemId).setQuantity(quantity);
            }
        }
    }

    public void removeItem(int cartItemId) {
        items.remove(cartItemId);
    }
    
    public void clear() {
        items.clear();
    }
}
