public interface ILinkedList<T> {
    void addFirst(T o);

    void addMiddle(T o, int i);

    void addLast(T o);

    T get(int i);

    void remove(int i);

}
