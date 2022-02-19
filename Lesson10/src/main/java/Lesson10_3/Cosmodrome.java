package Lesson10_3;

public class Cosmodrome {

    public void startCosmodrome(IStart iStart) {
        if (!iStart.isCheck()) {
            System.out.println("Предстартовая проверка провалена");
        } else {
            iStart.startEngines();
            iStart.start();
        }
    }
}
