import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
public class CashDesk {
    private String cashDeskName;
    private ReentrantLock reentrantLock;

    public CashDesk(String cashDeskName) {
        this.cashDeskName = cashDeskName;
        reentrantLock = new ReentrantLock();
    }
    private String getCashDeskName(){
        return this.cashDeskName;
    }
}
