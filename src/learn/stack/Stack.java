package learn.stack;

public interface Stack<E>{
    int getSize();
    boolean isEmpty();
    E pop();
    void push(E e);
    E peek(E e);
}
