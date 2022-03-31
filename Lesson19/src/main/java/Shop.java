public class Shop implements Runnable {

    public Shop() {
    }

    @Override
    public void run() {
        System.out.printf("Поток %s начал свою работу", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.printf("Остановка %s потока", Thread.currentThread().getName());
    }
}