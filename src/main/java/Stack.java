public class Stack<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        data[size] = element;
        size ++;
    }
    public T pop() {
        size --;
        return data[size];
    }
    public T peek() {
        return data[size - 1];
    }
}