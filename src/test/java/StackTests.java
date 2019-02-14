import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackTests {
    @Test
    public void increaseCapacity() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Assert.assertEquals(12, stack.size());
        Assert.assertEquals((Integer) 11, stack.get(11));
    }

    @Test
    public void popElement() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Assert.assertEquals((Integer) 11, stack.pop());
        Assert.assertEquals(11, stack.size());
    }

    @Test
    public void peekElement() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Assert.assertEquals((Integer) 11, stack.peek());
        Assert.assertEquals(12, stack.size());
    }

    @Test
    public void equals() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack2.push(i);
        }

        Assert.assertTrue(stack.equals(stack2));
        Assert.assertTrue(stack2.equals(stack));
    }

    @Test
    public void notEqualsSameSizeAndType() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = 11; i <= 0; i--) {
            stack2.push(i);
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void notEqualsDifferentSize() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i <= 10; i++) {
            stack2.push(i);
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void notEqualsDifferentType() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack2.push('a');
        }

        Assert.assertFalse(stack.equals(stack2));
        Assert.assertFalse(stack2.equals(stack));
    }

    @Test
    public void remove() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        stack.remove(7);

        Assert.assertEquals((Integer) 8, stack.get(7));
        Assert.assertEquals(11, stack.size());
    }

    @Test
    public void removeAll() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i / 2);
        }

        Assert.assertEquals((Integer) 3, stack.get(6));
        Assert.assertEquals((Integer) 3, stack.get(7));
        stack.removeAll(3);
        Assert.assertEquals((Integer) 4, stack.get(6));
        Assert.assertEquals((Integer) 4, stack.get(7));
        Assert.assertEquals(10, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void popElementEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBounds() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= 11; i++) {
            stack.push(i);
        }

        stack.get(12);
    }

}
