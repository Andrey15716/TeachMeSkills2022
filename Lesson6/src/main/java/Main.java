public class Main {

    public static void main(String[] args) {

        User user = new User("Andrey", "Antonenko");
        User.info();

        user.age = 28;
        user.about = "I am a human";

        User user1 = new User();
        user1.about = "student";
        user1.surname = "Robotic";

        User user2 = new User(28, 80);
        User.name = "Robot";
        user2.about = "I am a machine";

        System.out.println(User.name);
    }
}
