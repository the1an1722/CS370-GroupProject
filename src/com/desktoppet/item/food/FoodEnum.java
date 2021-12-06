package com.desktoppet.item.food;

/**
 * Description: Item list
 *
 * @author Shengliang Yu
 */
public enum FoodEnum {

    MILK("Milk", "FOOD_001", "foods/milk.jpeg", 5, "eating.gif"),
    EGG("Egg", "FOOD_002", "foods/egg.jpeg", 10, "eating.gif");

    /**
     * food name
     */
    private final String name;
    /**
     * food id
     */
    private final String id;
    /**
     * image path
     */
    private final String path;
    /**
     * how many buff can increase by eat one food
     */
    private final int buff;
    /**
     * image path
     */
    private final String actionPath;

    public static final String pathPrefix = "/com/desktoppet/img/";

    FoodEnum(String name, String id, String path, int buff, String actionPath) {
        this.name = name;
        this.id = id;
        this.path = path;
        this.buff = buff;
        this.actionPath = actionPath;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return pathPrefix + path;
    }

    public int getBuff() {
        return buff;
    }

    public String getActionPath() {
        return pathPrefix + actionPath;
    }
}
