package task2;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class PrintClass<T, V, K> {
    private T obT;
    private V obV;
    private K obK;

    public PrintClass(T obT, V obV, K obK) {
        this.obT = obT;
        this.obV = obV;
        this.obK = obK;
    }

    public static <T extends Comparable<T>> String text(T a) {
        return a.toString();
    }

    public static <V extends Animal & Serializable> String name(V b) {
        return b.toString();
    }

    public static <K extends Number> double sum(K c) {
        return c.doubleValue();
    }

    public void showTypes() {
        System.out.println("Тип T " + obT.getClass().getName());
        System.out.println("Тип V " + obV.getClass().getName());
        System.out.println("Тип K " + obK.getClass().getName());
    }
}
