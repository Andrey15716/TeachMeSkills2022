package lesson11_1;

public class Main {
    /**
     * Задача1:
     * Интерфейс Инструмент
     * <p>
     * 1) Создать интерфейс Инструмент(внутри enum Type с перечислением типов инструментов) и реализующие его классы Гитара, Барабан и Труба.
     * 2) Интерфейс Инструмент содержит метод play() и переменную String KEY ="До мажор".
     * 3) Гитара содержит переменные класса количествоСтрун,  Барабан - размер, Труба - диаметр.
     * 4) Создать массив типа Инструмент, содержащий инструменты разного типа.
     * 5) Наполнять массив инструментами необходимо через метод createInstrument,
     * который на вход принимает Тип инструмента(enum) и создает конкретный инструмент.
     * 6) В цикле вызвать метод play() для каждого инструмента, который должен выводить строку
     * "Играет такой-то инструмент, с такими-то характеристиками".
     */

    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[3];
        instruments[0] = createInstrument(Instrument.Instruments.GUITAR);
        instruments[1] = createInstrument(Instrument.Instruments.DRUMS);
        instruments[2] = createInstrument(Instrument.Instruments.TRUMPET);

        for (Instrument playInstrument : instruments) {
            playInstrument.play();
        }
    }

    public static Instrument createInstrument(Instrument.Instruments type) {
        return switch (type) {
            case DRUMS -> new Drums(12);
            case GUITAR -> new Guitar(6);
            case TRUMPET -> new Trumpet(10);
        };
    }
}
