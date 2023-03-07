import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class InventoryFactory {
    public enum InventoryType {
        HASHMAP,
        TREEMAP,
        LINKEDHASHMAP
    }

    public static Inventory createInventory(InventoryType type) {
        switch (type) {
            case HASHMAP:
                return new Inventory(new HashMap<>());
            case TREEMAP:
                return new Inventory(new TreeMap<>());
            case LINKEDHASHMAP:
                return new Inventory(new LinkedHashMap<>());
            default:
                throw new IllegalArgumentException("Invalid inventory type");
        }
    }
}
