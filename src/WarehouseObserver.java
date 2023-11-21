// Класс WarehouseObserver реализует интерфейс Observer и представляет наблюдателя, специализированного на наблюдении за хранилищем продуктов.
// Этот класс реагирует на уведомления от хранилища и выводит сообщения о событиях на консоль.

class WarehouseObserver implements Observer {
    // Метод update вызывается при получении уведомления от хранилища.
    // Он выводит сообщение, информирующее о событии, на консоль.
    @Override
    public void update(String message) {
        System.out.println("Warehouse Observer: " + message);
    }
}
