import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание экземпляра хранилища продуктов (Singleton pattern)
        ProductWarehouse warehouse = ProductWarehouse.getInstance();

        // Создание наблюдателя и регистрация его в хранилище (Observer pattern)
        Observer warehouseObserver = new WarehouseObserver();
        warehouse.addObserver(warehouseObserver);

        while (true) {
            System.out.println("Product Warehouse Menu:");
            System.out.println(" ");
            System.out.println("1. Add Product (Legacy)");
            System.out.println("2. Add Product (New)");
            System.out.println("3. Remove Product");
            System.out.println("4. View Products");
            System.out.println("5. Sort Products");
            System.out.println("6. Find Product by Barcode");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Добавление продукта в старом формате (Legacy)
                    System.out.print("Enter product name (Legacy): ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product barcode (Legacy): ");
                    String barcode = scanner.nextLine();
                    System.out.print("Enter product price (Legacy): ");
                    double price = scanner.nextDouble();

                    // Использование "Adapter pattern" для адаптации старого формата продукта к новому
                    LegacyProduct legacyProduct = new LegacyProduct(name, barcode, price);
                    ProductAdapter adapter = new ProductAdapter(legacyProduct);
                    Product newProduct = adapter.adaptToNewProduct();

                    // Использование "Decorator паттерна" для оборачивания нового продукта
                    warehouse.addProduct(new ProductDecorator(newProduct));
                    System.out.println("Product added successfully.");
                    System.out.println(" ");
                    break;

                case 2:
                    // Добавление продукта в новом формате
                    System.out.print("Enter product name (New): ");
                    name = scanner.nextLine();
                    System.out.print("Enter product barcode (New): ");
                    barcode = scanner.nextLine();
                    System.out.print("Enter product price (New): ");
                    price = scanner.nextDouble();

                    // Использование "Factory pattern" для создания нового продукта
                    Product product = ProductFactory.createProduct(name, barcode, price);
                    warehouse.addProduct(new ProductDecorator(product));
                    System.out.println("Product added successfully. ");
                    System.out.println(" ");
                    break;

                case 3:
                    // Удаление продукта из хранилища
                    System.out.print("Enter product barcode to remove: ");
                    System.out.println(" ");
                    String removeBarcode = scanner.nextLine();
                    warehouse.removeProduct(removeBarcode);
                    System.out.println("Product removed successfully. ");
                    System.out.println(" ");
                    break;

                case 4:
                    // Отображение списка продуктов
                    System.out.println("List of Products: ");
                    System.out.println(" ");

                    // Сортировка продуктов и отображение их (Strategy pattern)
                    warehouse.sortProducts();
                    List<Product> products = warehouse.getAllProducts();

                    // Вывод продуктов
                    if (products.isEmpty()) {
                        System.out.println("No products in the warehouse. ");
                        System.out.println(" ");
                    } else {
                        System.out.println("| Product Name        | Barcode   | Price     |");
                        System.out.println(" ");
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    // Выбор стратегии сортировки (Strategy pattern)
                    System.out.println("Select sorting criteria:");
                    System.out.println("1. Sort by Price");
                    System.out.println("2. Sort by Name");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (sortChoice) {
                        case 1:
                            warehouse.setSortingStrategy(new PriceProductSortingStrategy());
                            System.out.println("Sorted by Price.");
                            break;
                        case 2:
                            warehouse.setSortingStrategy(new NameProductSortingStrategy());
                            System.out.println("Sorted by Name.");
                            break;
                        default:
                            System.out.println("Invalid sorting choice.");
                            break;
                    }
                    break;

                case 6:
                    // Поиск продукта по штрихкоду
                    System.out.print("Enter product barcode to find: ");
                    String findBarcode = scanner.nextLine();
                    Product foundProduct = warehouse.findProductByBarcode(findBarcode);
                    if (foundProduct != null) {
                        System.out.println("Product found: " + foundProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7:
                    // Выход из приложения
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
