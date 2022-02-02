
public class Main {

    public static void main(String[] args) {

        User user1 = new User("Andrey", "Antonenko", 28, 78, "I am a human");

        User user2 = new User();
        user2.name = "Robotic";
        user2.surname = "Roboto";
        user2.age = 10;
        user2.height = 312;
        user2.about = " I am a machine";

        user1.addAge();
        user2.addAge();

        user1.changeName();

        user1.getFullInformation();
        user2.getFullInformation();
    }
}


