package com.desktoppet.img;

import javafx.scene.image.Image;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * Description: Resource Getter
 *
 * @author Shengliang Yu
 */
public class ResourceGetter {

    private static final Map<String, Image> images = new WeakHashMap<>();
    private static ResourceGetter singleton;

    public static ResourceGetter getInstance() {
        if (singleton == null) singleton = new ResourceGetter();
        return singleton;
    }

    private ResourceGetter() {
    }

    public Image get(String path) {
        if (!images.containsKey(path)) {
            images.put(path, new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path))));
        }
        return images.get(path);
    }

}
