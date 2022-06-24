public class CloneFactory {
    public Animal getClone(Animal anotherAnimal) throws CloneNotSupportedException {
        return anotherAnimal.copy();
    }
}
