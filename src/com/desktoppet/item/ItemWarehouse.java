package com.desktoppet.item;

import com.desktoppet.item.bath.BathEnum;
import com.desktoppet.item.bath.BathList;
import com.desktoppet.item.food.FoodEnum;
import com.desktoppet.item.food.FoodList;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Item inventory
 *
 * @author Shengliang Yu
 */
public class ItemWarehouse {

    private static ItemWarehouse itemWarehouse;

    private final Map<String, FoodList> foodItemMap = new HashMap<>();
    private final Map<String, BathList> bathItemMap = new HashMap<>();

    private ItemWarehouse() {
        // Default 10
        for (FoodEnum foodEnum : FoodEnum.values()) {
            foodItemMap.put(foodEnum.getId(), new FoodList(foodEnum, 10));
        }
        // Default 10
        for (BathEnum bathEnum : BathEnum.values()) {
            bathItemMap.put(bathEnum.getId(), new BathList(bathEnum, 10));
        }
    }

    public static ItemWarehouse getInstance() {
        if (itemWarehouse == null) itemWarehouse = new ItemWarehouse();
        return itemWarehouse;
    }

    public Map<String, FoodList> getFoodItemMap() {
        return foodItemMap;
    }

    public Map<String, BathList> getBathItemMap() {
        return bathItemMap;
    }
}
