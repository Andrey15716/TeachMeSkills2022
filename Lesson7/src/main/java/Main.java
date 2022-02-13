import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Address konstantinAddress = new Address("Belarus", "Minsk");
        Person konstantin = new Person("Константин", 20, Person.MALE, konstantinAddress);

        Address ivanAddress = new Address("Belarus", "Minsk");
        Person ivan = new Person("Александр", 30, Person.MALE, ivanAddress);

        Address olgaAddress = new Address("Belarus", "Minsk");
        Person olga = new Person("Ольга", 25, Person.FEMALE, olgaAddress);

        Person[] persons = {konstantin, ivan, olga};
//        System.out.println(Arrays.toString(persons));

        PersonRegistry personRegistry = new PersonRegistry(persons);
        MilitaryOffice militaryOffice = new MilitaryOffice(personRegistry);

        System.out.println(Arrays.toString(militaryOffice.findPersons("Belarus")));
        System.out.println(militaryOffice.countPeopleByCity("Minsk") + " - Количество призывников из Минска");
        System.out.println(militaryOffice.countPeopleByName("Александр") + " - Количество призывников с именем Александр");
        System.out.println(militaryOffice.countByAge(20, 27) + " - Количество призывников возраста от 20 до 27");
    }
}
