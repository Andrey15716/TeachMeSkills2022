public class test {
    public static void main(String[] args) {

//    public static boolean isPalindromes(byte firsts, byte seconds) {
//        if (firsts.length() != seconds.length()) {
//            return false;
//        }
//        for (int i = 0; i < firsts.length(); i++) {
//            if (firsts.charAt(i) != seconds.charAt(seconds.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
    }
//        try (FileWriter fileWriter = new FileWriter("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new - write.txt", true)) {
//            String text = "Helo";
//            fileWriter.write(text);
//            fileWriter.append("\n");
//            fileWriter.append("E");
//
//            fileWriter.flush();


//        try(PrintStream printStream = new PrintStream("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new - write.txt")) {
//            printStream.print("Hello world");
//            printStream.println("Welcome to Java");
//            printStream.printf("Name: %s Age: %d \n", "Tom", 34);
//
//            String message = "PrintStream";
//            byte[] message_toByte = message.getBytes();
//            printStream.write(message_toByte);
//            System.out.println("The file has been written");


//        String text = " Hello World";
//        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new - write.txt");
//             PrintStream printStream = new PrintStream(String.valueOf(fileInputStream))) {
//            printStream.println(text);
//            System.out.println("Запись в файл произведена");
//        } catch (IOException e) {
//            System.out.println(e.getMessage());

//        byte[] array1 = new byte[]{1, 3, 5, 7};
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
//        int b;
//        while ((b = byteArrayInputStream.read()) != -1) {
//            System.out.println(b);
//        }
//        String text = "Hello";
//        byte[] array2 = text.getBytes();
//        ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(array2, 0, 5);
//        int c;
//        while ((c = byteArrayInputStream1.read()) != -1) {
//            System.out.println((char) c);

//        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new - read.txt");
//             FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new - write.txt")) {
//
//            byte[] buffer = new byte[fileInputStream.available()];
//            fileInputStream.read(buffer, 0, buffer.length);
//            fileOutputStream.write(buffer,0, buffer.length);
//
//            System.out.println("file data :");
//            for (byte b : buffer) {
//                System.out.println((char) b);
//            }

/*        String text = "BY";
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\u108\\IdeaProjects\\TeachMeSkills2022\\Lesson14\\new.txt")) {
            byte[] buffer = text.getBytes();
            fileOutputStream.write(buffer[0]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Файл был записан!");*/
//        } catch(IOException e){
//            System.out.println(e.getMessage());
//        }
    }
