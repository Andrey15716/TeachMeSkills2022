import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        //вывод на консоль

        printEnglish();
        printChet();
        printLower();
        time();
        castingType();

    }


    //Задачи:
    //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита
    public static void printEnglish() {
        char i;
        for (i = 'a'; i <= 'z'; i++) {
            System.out.println(i);
        }
    }


    //2)Проверка четности числа
    //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
    // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
    // Если пользователь введёт не целое число, то сообщать ему об ошибке.
    private static void printChet() {

        int a;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число");

        a = input.nextInt();

        if (a % 2 == 0) {
            System.out.println("Ввели ЧЕтное число");
        } else
            System.out.println("Ввели НЕчетное число");
    }


    //3) Меньшее по модулю число
    //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
    // пользователем вещественных чисел с консоли.
    private static void printLower() {

        int a;
        int b;
        int c;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число");

        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        int smallest = (a < b) ? (Math.min(a, c)) : (Math.min(b, c));
        System.out.println(smallest);

    }

    //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
    // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
    // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
    // (т.е. рабочий день закончился).
    //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
    // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
    // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
    //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
    // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
    // выводиться фраза о количестве полных часов, содержащихся в n секундах.

    private static void time() {

        final int SEC_PER_MIN = 60;
        final int MIN_PER_HOUR = 60;
        final int TOTAL_SEC = 28800;

        int random_number = (int) (Math.random() * TOTAL_SEC); // Генерация числа
        int hour = (random_number / SEC_PER_MIN) / MIN_PER_HOUR;

        System.out.println("Время для Петрова: " + random_number);

        if (hour < 1) {
            System.out.println("Осталось менее часа");
        }else if (hour == 1) {
            System.out.println("Остался " + hour + " час");
        }else if (hour >= 2 && hour <= 4) {
            System.out.println("Осталось " + hour + " часа");
        }else {
            System.out.println("Осталось " + hour + " часов");
        }
    }


    //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn
    private static void castingType() {

        System.out.println("""
                      boolean   byte   short   char   int   long   float   double
                byte     x       т      ня      я     ня     ня     ня      ня
                short    x       я       т      я     ня     ня     ня      ня
                char     x       я       я      т     ня     ня     ня      ня
                int      x       я       я      я     т      ня     ня      ня
                long     x       я       я      я     я       т     ня      ня
                float    x       я       я      я     я       я      т      ня
                double   x       я       я      я     я       я      я       т
                boolean  -       x       x      x     x       x      x       x
                """);
    }
    }
