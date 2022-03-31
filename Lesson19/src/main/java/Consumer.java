import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Consumer extends Thread {
    private String[] products;
    private CashDesk[] cashDesks;

    public Consumer(String name, String[] products, CashDesk[] cashDesks) {
        super(name);
        this.products = products;
        this.cashDesks = cashDesks;
        this.start();
    }

    public String[] getProducts(Consumer consumer) {
        return this.products;
    }

    @Override
    public void run() {
        CashDesk desk = cashDesks[0];

        while (true) {
            for (CashDesk cashdesk: cashDesks) {
                if (cashdesk.getReentrantLock().getQueueLength() < desk.getReentrantLock().getQueueLength()) {
                    desk = cashdesk;
                    break;
                }
            }
            System.out.println(Arrays.toString(getProducts(this)));
        }
    }
}
