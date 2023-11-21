import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Класс NameProductSortingStrategy представляет "Strategy pattern" сортировки продуктов по имени (в алфавитном порядке).
class NameProductSortingStrategy implements ProductSortingStrategy {

    // Метод sort выполняет сортировку списка продуктов по имени и возвращает отсортированный список.
    @Override
    public List<Product> sort(List<Product> products) {
        // Используется Java Stream API для сортировки продуктов по имени в алфавитном порядке.
        return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }
}
