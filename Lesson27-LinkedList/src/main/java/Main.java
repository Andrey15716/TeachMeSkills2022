public class Main {
    public static void main(String[] args) {
        LinkedListImpl<String> linkedList = new LinkedListImpl<>();
        linkedList.addFirst("44");
        linkedList.addFirst("66");
        linkedList.addFirst("76");
        linkedList.addFirst("86");
        linkedList.addLast("11");
        linkedList.addMiddle("4", 1);
        linkedList.print();
        System.out.println("size - " + linkedList.getSize());
        linkedList.removeFirst();
        System.out.println();
        linkedList.removeLast();
        linkedList.print();
        System.out.println();
        linkedList.remove(2);
        linkedList.print();
        System.out.println("size - " + linkedList.getSize());
        System.out.println();
        System.out.println("get element by index - " + linkedList.get(2));
    }
}