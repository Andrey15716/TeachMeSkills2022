import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRegistry {

    private Person[] persons;

    public PersonRegistry(Person[] persons) {
        this.persons = persons;
    }
}
