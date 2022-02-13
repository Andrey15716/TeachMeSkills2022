import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    public static final String MALE = "Мужской";
    public static final String FEMALE = "Женский";
    private String name;
    private int age;
    private String sex;
    private Address address;

    public Person(String name, int age, String sex, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Призывник " +
                "Имя - " + name + '\'' +
                ", Возраст - " + age +
                ", Пол - " + sex + '\'' +
                ", Город - " + address.getCity() + '\'' +
                ", Страна - " + address.getCountry() + ']';
    }
}