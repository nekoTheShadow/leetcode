package maximu_frequency_stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FreqStackTest {

    @Test
    void example1() {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
    }

}
