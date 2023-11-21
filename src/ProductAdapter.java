// Класс ProductAdapter реализует интерфейс ProductAdapterInterface и представляет собой адаптер, который
// преобразует объекты старого формата продукта (LegacyProduct) в новый формат продукта (Product).
class ProductAdapter implements ProductAdapterInterface {
    private LegacyProduct legacyProduct; // Объект старого формата продукта (LegacyProduct)

    // Конструктор класса, который принимает объект старого формата продукта и инициализирует его.
    public ProductAdapter(LegacyProduct legacyProduct) {
        this.legacyProduct = legacyProduct;
    }

    // Реализация метода adaptToNewProduct интерфейса ProductAdapterInterface для адаптации старого формата продукта
    // к новому формату, используя ProductFactory.
    @Override
    public Product adaptToNewProduct() {
        // Используется ProductFactory для создания нового продукта на основе данных старого формата продукта.
        return ProductFactory.createProduct(legacyProduct.getName(), legacyProduct.getBarcode(), legacyProduct.getPrice());
    }
}
