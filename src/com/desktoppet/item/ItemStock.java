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
public class ItemStock {

    private static ItemStock itemWarehouse;

    private final Map<String, FoodList> foodItemMap = new HashMap<>();
    private final Map<String, BathList> bathItemMap = new HashMap<>();

    private ItemStock() {
        // Default 22
        for (FoodEnum foodEnum : FoodEnum.values()) {
            foodItemMap.put(foodEnum.getId(), new FoodList(foodEnum, 22));
        }
        // Default 22
        for (BathEnum bathEnum : BathEnum.values()) {
            bathItemMap.put(bathEnum.getId(), new BathList(bathEnum, 22));
        }
    }

    public static ItemStock getInstance() {
        if (itemWarehouse == null) itemWarehouse = new ItemStock();
        return itemWarehouse;
    }

    public Map<String, FoodList> getFoodItemMap() {
        return foodItemMap;
    }

    public Map<String, BathList> getBathItemMap() {
        return bathItemMap;
    }
}
