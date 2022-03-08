package task2;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PrintClass<T extends Comparable<T>, V extends Animal & Serializable, K extends Number> {
    private T obT;
    private V obV;
    private K obK;

    public PrintClass(T obT, V obV, K obK) {
        this.obT = obT;
        this.obV = obV;
        this.obK = obK;
    }

    public void showTypes() {
        System.out.println("Тип T " + obT.getClass().getName());
        System.out.println("Тип V " + obV.getClass().getName());
        System.out.println("Тип K " + obK.getClass().getName());
    }
}