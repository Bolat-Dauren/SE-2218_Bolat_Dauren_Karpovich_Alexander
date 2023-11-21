import java.util.List;

// Класс DefaultProductSortingStrategy представляет "Strategy pattern" сортировки продуктов по умолчанию.
class DefaultProductSortingStrategy implements ProductSortingStrategy {

    // Метод sort принимает список продуктов и возвращает его без изменений, не выполняя сортировку.
    @Override
    public List<Product> sort(List<Product> products) {
        return products; // Стратегия сортировки по умолчанию (без сортировки)
    }
}
