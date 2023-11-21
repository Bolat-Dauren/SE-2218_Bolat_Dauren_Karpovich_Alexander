import java.util.*;
//import java.util.stream.Collectors;

// Класс ProductWarehouse реализует "Singleton pattern" и представляет хранилище продуктов.
// Этот класс управляет добавлением, удалением, поиском и сортировкой продуктов, а также регистрацией и уведомлением наблюдателей.

class ProductWarehouse {
    private static ProductWarehouse instance; // Статическая переменная для хранения единственного экземпляра хранилища.
    private List<Product> products; // Список продуктов в хранилище.
    private ProductSortingStrategy sortingStrategy; // Стратегия сортировки продуктов.
    private List<Observer> observers; // Список наблюдателей для уведомлений.

    // Приватный конструктор класса. Вызывается только один раз при создании экземпляра хранилища.
    private ProductWarehouse() {
        products = new ArrayList<>(); // Инициализация списка продуктов.
        sortingStrategy = new DefaultProductSortingStrategy(); // Инициализация стратегии сортировки по умолчанию.
        observers = new ArrayList<>(); // Инициализация списка наблюдателей.
    }

    // Метод для получения единственного экземпляра хранилища (паттерн Singleton).
    public static ProductWarehouse getInstance() {
        if (instance == null) {
            instance = new ProductWarehouse();
        }
        return instance;
    }

    // Метод для добавления продукта в хранилище.
    public void addProduct(Product product) {
        products.add(product);
        notifyObservers("Product added: " + product.getName());
    }

    // Метод для удаления продукта из хранилища по штрихкоду.
    public void removeProduct(String barcode) {
        products.removeIf(p -> p.getBarcode().equals(barcode));
        notifyObservers("Product removed with barcode: " + barcode);
    }

    // Метод для поиска продукта по штрихкоду.
    public Product findProductByBarcode(String barcode) {
        for (Product product : products) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        return null; // Если продукт не найден, возвращается null.
    }

    // Метод для получения списка всех продуктов в хранилище.
    public List<Product> getAllProducts() {
        return products;
    }

    // Метод для установки стратегии сортировки продуктов.
    public void setSortingStrategy(ProductSortingStrategy strategy) {
        sortingStrategy = strategy;
        notifyObservers("Sorting strategy changed");
    }

    // Метод для сортировки продуктов в хранилище с использованием текущей стратегии.
    public void sortProducts() {
        products = sortingStrategy.sort(products);
    }

    // Метод для добавления наблюдателя в список наблюдателей.
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }

    // Приватный метод для уведомления всех наблюдателей с передачей сообщения.
    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
