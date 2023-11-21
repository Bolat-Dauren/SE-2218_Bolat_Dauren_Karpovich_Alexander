// Класс ProductFactory представляет собой "Fabric pattern" для создания объектов продукта (Product) в новом формате.
class ProductFactory {
    // Метод createProduct является фабричным методом для создания нового продукта.
    // Принимает параметры, такие как имя, штрихкод и цена, и возвращает новый объект продукта.
    public static Product createProduct(String name, String barcode, double price) {
        return new Product(name, barcode, price); // Создание и возвращение нового продукта.
    }
}
