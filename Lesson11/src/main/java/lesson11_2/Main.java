package lesson11_2;

public class Main {

    /**
     * Задача2: Времена года
     * *
     * * 1) Создать перечисление, содержащее названия времен года.
     * * 2) Создать переменную содержащую ваше любимое время года и распечатать всю информацию о нем.
     * * 3) Создать метод, который принимает на вход переменную созданного вами enum типа.
     * *  Если значение равно Лето, выводим на консоль “Я люблю лето” и так далее. Используем оператор switch.
     * * 4) Перечисление должно содержать переменную, содержащую среднюю температуру в каждом времени года.
     * * 5) Добавить конструктор принимающий на вход среднюю температуру.
     * * 6) Создать метод getDescription, возвращающий строку “Холодное время года”.
     * *  Переопределить метод getDescription - для константы Лето метод должен возвращать “Теплое время года”.
     * * 7) В цикле распечатать все времена года, среднюю температуру и описание времени года.
     */

    public static void main(String[] args) {

        Season[] seasons = new Season[4];
        seasons[0] = getSeason(Season.type.AUTUMN);
        seasons[1] = getSeason(Season.type.SPRING);
        seasons[2] = getSeason(Season.type.SUMMER);
        seasons[3] = getSeason(Season.type.WINTER);

        for (Season season : seasons) {
            season.getDescription();
        }
    }

    public static Season getSeason(Season.type season) {
        switch (season) {
            case AUTUMN:
                return new Autumn(5);
            case SPRING:
                return new Spring(15);
            case SUMMER:
                return new Summer(24);
            case WINTER:
                return new Winter(-5);
        }
        return new Spring(15);
    }
}
