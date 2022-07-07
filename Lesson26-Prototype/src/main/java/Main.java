public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneFactory animalCreator = new CloneFactory();
        Sheep sally = new Sheep();

        Sheep clonedSheep = (Sheep) animalCreator.getClone(sally);

        System.out.println(sally);
        System.out.println(clonedSheep);
    }
}
