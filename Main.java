import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String INVENTORY_FILE = "inventario.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an inventory type:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");
        int choice = scanner.nextInt();
        InventoryFactory.InventoryType type = null;
        switch (choice) {
            case 1:
                type = InventoryFactory.InventoryType.HASHMAP;
                break;
            case 2:
                type = InventoryFactory.InventoryType.TREEMAP;
                break;
            case 3:
                type = InventoryFactory.InventoryType.LINKEDHASHMAP;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        Inventory inventory = InventoryFactory.createInventory(type);
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    inventory.addProduct(parts[0].trim(), 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory file");
            e.printStackTrace();
            return;
        }
        int option;
        do {
            System.out.println();
            System.out.println("Select an option:");
            System.out.println("1) Add product");
            System.out.println("2) Show product category");
            System.out.println("3) Show inventory");
            System.out.println("4) Show sorted inventory");
            System.out.println("5) Show products");
            System.out.println("6) Show sorted products");
            System.out.println("0) Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter product category: ");
                    String category = scanner.next();
                    if (inventory.getProducts().containsKey(category)) {
                        inventory.addProduct(category, 1);
                    } else {
                        System.out.println("Invalid category");
                    }
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    String productCategory = inventory.getCategory(name);
                    if (productCategory != null) {
                        System.out.println(productCategory);
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                case 3:
                    inventory.showInventory();
                    break;
                case 4:
                    inventory.showInventorySorted();
                    break;
                case 5:
                    inventory.showProducts();
                    break;
                case 6:
                    inventory.showProductsSorted();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (option != 0);
    }
}
