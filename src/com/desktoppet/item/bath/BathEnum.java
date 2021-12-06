package com.desktoppet.item.bath;

import com.desktoppet.constant.Constant;

/**
 * Description: Bath List
 *
 * @author Shengliang Yu
 */
public enum BathEnum {

    SOAP("Soap", "BATH_001", Constant.ImageShow.ItemImage.soapImage, 10, Constant.ImageShow.bathImage);

    /**
     * Bath name
     */
    private final String name;
    /**
     * Bath id
     */
    private final String id;
    /**
     * Image path
     */
    private final String path;
    /**
     * how many buff can increase by bath it
     */
    private final int buff;
    /**
     * Image path
     */
    private final String actionPath;

    BathEnum(String name, String id, String path, int buff, String actionPath) {
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
        return path;
    }

    public int getBuff() {
        return buff;
    }

    public String getActionPath() {
        return actionPath;
    }
}
