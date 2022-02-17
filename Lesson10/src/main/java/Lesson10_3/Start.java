package Lesson10_3;

public class Start {
    public static void main(String[] args) {
        Cosmodrome cosmodrome = new Cosmodrome();
        cosmodrome.startCosmodrome(new Shuttle());
        cosmodrome.startCosmodrome(new SpaceX());
    }
}