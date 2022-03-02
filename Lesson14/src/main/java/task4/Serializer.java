package task4;

import java.io.*;

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