package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Map<Long, Item>> itemDataBase = new HashMap<>();
    private Long maxIndex;

    @Override
    public List<Item> findByUserId(Long userId) {
        Map<Long, Item> itemMap = itemDataBase.getOrDefault(userId, new HashMap<>());
        List<Item> itemList = new ArrayList<>(itemMap.values());

        return itemList;
    }

    @Override
    public Item save(Item item) {
        Long userId = item.getUserId();
        item.setId(getIndex());
        Map<Long, Item> itemList = itemDataBase.getOrDefault(userId, new HashMap<>());
        itemList.put(item.getId(), item);
        itemDataBase.put(userId, itemList);

        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        Map<Long, Item> itemList = itemDataBase.getOrDefault(userId, new HashMap<>());
        if (itemList.containsKey(itemId)) {
            itemList.remove(itemId);
        }
    }

    private Long getIndex() {
        if (maxIndex == null) {
            maxIndex = 0L;
        }
        maxIndex++;

        return maxIndex;
    }
}
