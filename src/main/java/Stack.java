import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private int top = -1;
    private E[] elements = (E[]) new Object[10];

    public void push(E value) {
        if (top >= elements.length - 1) {
            expandSize();
        }
        elements[++top] = value;
    }

    public E peek() {
        if (top < 0) {
            throw new EmptyStackException();
        }
        return elements[top];
    }

    public E pop() {
        if (top < 0) {
            throw new EmptyStackException();
        }
        return elements[top--];
    }

    public void remove(int index) {
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        top--;
    }

    public void removeAll(E value) {
        int numSwaps = 0;
        for (int i = 0; i <= top; i++) {
            if (elements[i - numSwaps].equals(value)) {
                remove(i - numSwaps);
                numSwaps++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Stack<?> && ((Stack<?>) obj).size() == this.size()) {
            for (int i = 0; i < top; i++) {
                if (!((Stack<?>) obj).get(i).equals(this.get(i))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public E get(int index) {
        if (top < index) {
            throw new IndexOutOfBoundsException();
        }

        return elements[index];
    }

    public int size() {
        return top + 1;
    }

    private void expandSize() {
        int increasedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, increasedSize);
    }
}
