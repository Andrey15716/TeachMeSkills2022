public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (String value : args) {
            int k = Integer.parseInt(value);
            if (k>0){
               count++;
            }
        }
        System.out.println("Количество положительных чисел " + count);
    }
}
