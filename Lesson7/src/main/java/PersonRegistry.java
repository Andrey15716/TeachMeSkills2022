import lombok.Data;

@Data
public class PersonRegistry {

    private Person[] persons;

    public PersonRegistry(Person[] persons) {
        this.persons = persons;
    }
}

