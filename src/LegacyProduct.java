// Класс LegacyProduct представляет продукт в старом (Legacy) формате данных.
class LegacyProduct {
    private String name;    // Наименование продукта
    private String barcode; // Штрихкод продукта
    private double price;   // Цена продукта

    // Конструктор класса LegacyProduct, принимающий наименование, штрихкод и цену продукта.
    public LegacyProduct(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    // Метод getName возвращает наименование продукта.
    public String getName() {
        return name;
    }

    // Метод getBarcode возвращает штрихкод продукта.
    public String getBarcode() {
        return barcode;
    }

    // Метод getPrice возвращает цену продукта.
    public double getPrice() {
        return price;
    }
}
