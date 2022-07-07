public class Sheep implements Animal {

    public Sheep() {
        System.out.println("Sheep is made");
    }

    @Override
    public Animal copy() throws CloneNotSupportedException {
        System.out.println("Sheep is being made");
        return (Sheep) super.clone();
    }

    @Override
    public String toString() {
        return "Dolly sheep";
    }
}