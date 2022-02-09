import lombok.Data;

@Data
public class MilitaryOffice {

    private PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    public Person[] findPersons() {
        Person[] result = new Person[personRegistry.getPersons().length];
        int count = 0;
        for (int i = 0; i < personRegistry.getPersons().length; i++) {
            Person person = personRegistry.getPersons()[i];
            if (person.getAge() >= 18 && person.getAge() < 27 && person.getSex().equals(Person.MALE) && person.getAddress().getCountry().equals("Беларусь")) {
                result[i] = person;
            } else {
                count++;
            }
        }
        return result;
    }

    public int countPeopleByCity(String city) {
        Person[] persons = personRegistry.getPersons();
        int count = 0;
        for (Person result : persons) {
            if (result.getAddress().getCity().equals(city) && result.getSex().equals(Person.MALE)) {
                count++;
            }
        }
        return count;
    }

    public int countPeopleByName(String name) {
        int count = 0;
        for (Person personByName : personRegistry.getPersons()) {
            if (personByName.getName().equals(name) && personByName.getAge() >= 18 && personByName.getAge() < 27 && personByName.getSex().equals(Person.MALE)) {
                count++;
            }
        }
        return count;
    }

    public int countByAge(int min, int max) {
        Person[] result = personRegistry.getPersons();
        int count = 0;
        for (Person person : result) {
            int age = person.getAge();
            if (age >= min && age <= max && person.getSex().equals(Person.MALE)) {
                count++;
            }
        }
        return count;
    }

    public PersonRegistry getPersonRegistry() {
        return personRegistry;
    }

    public void setPersonRegistry(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }
}