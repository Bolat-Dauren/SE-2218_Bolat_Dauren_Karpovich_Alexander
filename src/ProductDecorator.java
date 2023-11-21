// Класс ProductDecorator представляет собой "Decorator pattern" для продукта, расширяющий функциональность базового продукта (Product).
class ProductDecorator extends Product {
    private Product product; // Ссылка на базовый продукт, который будет декорирован.

    // Конструктор класса, который принимает базовый продукт и инициализирует его.
    public ProductDecorator(Product product) {
        // Вызов конструктора суперкласса (Product) для инициализации полей базового продукта.
        super(product.getName(), product.getBarcode(), product.getPrice());
        this.product = product; // Инициализация ссылки на базовый продукт.
    }

    // Переопределение метода toString для формирования строкового представления декорированного продукта.
    @Override
    public String toString() {
        return product.toString(); // Вызов метода toString базового продукта для форматированного вывода.
    }
}
