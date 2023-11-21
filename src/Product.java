// Класс Product представляет собой модель продукта с наименованием, штрихкодом и ценой.
class Product {
    private String name;    // Наименование продукта
    private String barcode; // Штрихкод продукта
    private double price;   // Цена продукта

    // Конструктор класса Product, принимающий наименование, штрихкод и цену продукта.
    public Product(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    // Метод getBarcode возвращает штрихкод продукта.
    public String getBarcode() {
        return barcode;
    }

    // Метод getName возвращает наименование продукта.
    public String getName() {
        return name;
    }

    // Метод getPrice возвращает цену продукта.
    public double getPrice() {
        return price;
    }

    // Переопределение метода toString для форматированного вывода продукта в виде строки.
    @Override
    public String toString() {
        return String.format("| %-20s | %-10s | %-10.2f |", name, barcode, price);
    }
}
