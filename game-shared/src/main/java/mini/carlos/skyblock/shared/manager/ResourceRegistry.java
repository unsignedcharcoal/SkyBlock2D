package mini.carlos.skyblock.shared.manager;

import mini.carlos.skyblock.shared.tile.TileResource;

import java.util.HashMap;
import java.util.Map;

public class ResourceRegistry {

    private static final Map<Class<?>, TileResource<?>> resourceMap = new HashMap<>();

    public static void register(TileResource<?> resource) {
        resourceMap.put(resource.getClass(), resource);
    }

    public static void unregister(TileResource<?> resource) {
        resourceMap.remove(resource.getClass());
    }

    public static <T extends TileResource<?>> T get(Class<?> clazz) {
        return (T) resourceMap.get(clazz);
    }

}
