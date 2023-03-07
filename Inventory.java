import java.util.Map;

public class Inventory {
    private Map<String, Integer> products;

    public Inventory(Map<String, Integer> products) {
        this.products = products;
    }

    public void addProduct(String category, int quantity) {
        products.put(category, products.getOrDefault(category, 0) + quantity);
    }

    public String getCategory(String name) {
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() > 0 && entry.getKey().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void showInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    public void showInventorySorted() {
        System.out.println("Inventory (sorted):");
        products.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
    }

    public void showProducts() {
        System.out.println("Products:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
        }
    }

    public void showProductsSorted() {
        System.out.println("Products (sorted):");
        products.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        System.out.println(entry.getKey() + " | " + entry.getValue());
                    }
                });
    }
}
