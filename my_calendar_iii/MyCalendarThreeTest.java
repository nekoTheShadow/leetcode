package my_calendar_iii;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyCalendarThreeTest {
    @Test
    void example1() {
        MyCalendarThree tree = new MyCalendarThree();
        assertEquals(1, tree.book(10, 20));
        assertEquals(1, tree.book(50, 60));
        assertEquals(2, tree.book(10, 40));
        assertEquals(3, tree.book(5, 15));
        assertEquals(3, tree.book(5, 10));
        assertEquals(3, tree.book(25, 55));
    }

}
