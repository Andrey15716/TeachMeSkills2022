import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedListImpl<T> implements ILinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public static class Node<T> {
        Node<T> prev;
        T item;
        Node<T> next;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> getNode(int i) {
        if (i >= size) {
            return null;
        }
        if (i < (size >> 1)) {
            Node<T> x = first;
            for (int j = 0; j < 1; j++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int j = size - 1; j > i; j--) {
                x = x.prev;
            }
            return x;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public void addFirst(T o) {
        Node<T> newNode = new Node<>(null, o, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public void addLast(T o) {
        Node<T> newNode = new Node<T>(last, o, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.prev = last;
        last = newNode;
        size++;
    }

    @Override
    public void addMiddle(T o, int i) {
        Node<T> current = first;
        int c = 0;

        while (current != null && c != i) {
            current = current.next;
            c++;
        }
        Node<T> newNode = new Node<T>(last, o, first);
        current.prev.next = newNode;
        newNode.prev = current.prev;
        current.prev = newNode;
        newNode.next = current;
        size++;
    }

    @Override
    public T get(int i) {
        Node<T> x = getNode(i);
        return x == null ? null : x.item;
    }

    public void removeLast() {
        if (first.next == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
    }

    public void removeFirst() {
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        size--;
    }

    public void remove(int i) {
        Node<T> x = getNode(i);
        if (x == null) {
            return;
        }
        remove(x);
    }

    private void remove(Node<T> x) {
        Node<T> prev = x.prev;
        Node<T> next = x.next;

        if (prev == null) {
            first = x.next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = x.prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
    }

    public void print() {
        Node<T> newNode = first;
        while (newNode != null) {
            System.out.println(newNode.item);
            newNode = newNode.next;
        }
    }
}