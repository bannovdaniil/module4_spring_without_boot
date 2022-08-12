package ru.practicum.item;

import java.util.List;

interface ItemService {
    List<Item> getItems(Long userId);

    Item addNewItem(Long userId, Item item);

    void deleteItem(Long userId, Long itemId);
}