import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Класс PriceProductSortingStrategy представляет "Strategy pattern" сортировки продуктов по цене (по возрастанию).
class PriceProductSortingStrategy implements ProductSortingStrategy {

    // Метод sort выполняет сортировку списка продуктов по цене и возвращает отсортированный список.
    @Override
    public List<Product> sort(List<Product> products) {
        // Используется Java Stream API для сортировки продуктов по цене в порядке возрастания.
        return products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
    }
}
