package lesson11_1;

public interface Instrument {
    void play();

    enum Instruments {
        GUITAR,
        DRUMS,
        TRUMPET
    }

    String KEY = "До мажор";
}
