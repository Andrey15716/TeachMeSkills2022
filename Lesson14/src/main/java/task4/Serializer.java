package task4;

import java.io.*;

//Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров), бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
//        * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль
public class Serializer {
    public static <T> void serialize(T object, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object deserializer(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}