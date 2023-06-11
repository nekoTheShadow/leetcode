package snapshot_array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestSnapshotArray {

    @Test
    void example1() {
        var sa = new SnapshotArray(3);
        sa.set(0, 5);
        assertEquals(0, sa.snap());
        sa.set(0, 6);
        assertEquals(5, sa.get(0, 0));
    }

    @Test
    void example27() {
        var sa = new SnapshotArray(1);
        sa.set(0, 15);
        assertEquals(0, sa.snap());
        assertEquals(1, sa.snap());
        assertEquals(2, sa.snap());
        assertEquals(15, sa.get(0, 2));
        assertEquals(3, sa.snap());
        assertEquals(4, sa.snap());
        assertEquals(15, sa.get(0, 0));
    }
}
