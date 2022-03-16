package task3;

import org.codehaus.plexus.util.StringUtils;

import java.util.Arrays;
import java.util.List;

//Вывести список имен, но с первой заглавной буквой. список имен: "john", "arya", "sansa"

public class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("john", "arya", "sansa");
        stringList.stream().map(StringUtils::capitalise).forEach(System.out::println);
    }
}