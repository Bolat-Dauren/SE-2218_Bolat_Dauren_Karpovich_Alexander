import java.util.List;

// Интерфейс ProductSortingStrategy представляет "Strategy pattern" сортировки продуктов в приложении.
// Реализующие классы должны предоставить реализацию метода sort, который выполняет сортировку списка продуктов и возвращает отсортированный список.
interface ProductSortingStrategy {
    // Метод sort принимает список продуктов и возвращает отсортированный список на основе конкретной стратегии сортировки.
    List<Product> sort(List<Product> products);
}
