package task4;

import lombok.experimental.UtilityClass;

import java.io.*;

//Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
//        * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
@UtilityClass
public class Serializer {
    public static void serialize(Object obj, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> T deserializer(File file, Class<T> type) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object result = ois.readObject();
            if (type.isInstance(result)) {
                return type.cast(result);
            } else {
                throw new RuntimeException("Invalid class");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}