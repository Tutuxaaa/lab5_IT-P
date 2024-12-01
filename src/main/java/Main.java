public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Удаленный элемент: " + stack.pop());
        System.out.println("Верхний элемент: " + stack.peek());
        stack.push(4);
        System.out.println("Верхний элемент: " + stack.peek());
    }
}