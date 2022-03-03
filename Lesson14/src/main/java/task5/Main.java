package task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//Скопировать объект Car из пакета hw5, добавить библиотеки
//        * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3
//        * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.12.3
//        * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.12.3
//        * через maven в проект. Далее вычитать данные в json формате из файла (hw5/car.json), руками файл изменять нельзя!
//        * Преобразовать прочитанные данные в объект hw5.Car (название полей редактировать нельзя, добавлять поля также нельзя) и вывести на консоль объект через System.out.println();
public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Car car = objectMapper.readValue(new File("Lesson14\\src\\main\\java\\task5\\car.json"), Car.class);
            printInfo(car);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInfo(Car car) {
        System.out.println("brand " + car.getBrand());
        System.out.println("maxSpeed " + car.getMaxSpeed());
        System.out.println("price " + car.getPrice());
    }
}