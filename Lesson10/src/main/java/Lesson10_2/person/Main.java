package Lesson10_2.person;

import Lesson10_2.jacket.MarcoJacket;
import Lesson10_2.shoes.MarcoShoes;
import Lesson10_2.trousers.MarcoTrousers;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Andre", new MarcoJacket(), new MarcoTrousers(), new MarcoShoes());
        System.out.println(person.getName());
        person.dressUp();
        person.unDress();
    }
}
