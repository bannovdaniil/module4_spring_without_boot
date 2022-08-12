package ru.practicum.item;

import java.util.List;

interface ItemRepository {

    List<Item> findByUserId(Long userId);

    Item save(Item item);

    void deleteByUserIdAndItemId(long userId, long itemId);

}