package Lesson10_2.person;

import Lesson10_2.jacket.IJacket;
import Lesson10_2.shoes.IShoes;
import Lesson10_2.trousers.ITrousers;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person implements IDressingRoom {
    private String name;
    private IJacket jacket;
    private ITrousers trousers;
    private IShoes shoes;

    public Person(String name, IJacket jacket, ITrousers trousers, IShoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.trousers = trousers;
        this.shoes = shoes;
    }

    public Person() {
    }

    @Override
    public void dressUp() {
        jacket.putOn();
        trousers.putOn();
        shoes.putOn();
    }

    @Override
    public void unDress() {
        jacket.takeOff();
        trousers.takeOff();
        shoes.takeOff();
    }
}
