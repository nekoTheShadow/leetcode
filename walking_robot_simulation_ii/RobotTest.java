package walking_robot_simulation_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {

    @Test
    void example1() {
        // 初期化: 6 x 3 のグリッド
        Robot robot = new Robot(6, 3);

        // step(2), step(2)
        robot.step(2);
        robot.step(2);

        // getPos() -> [4, 0], getDir() -> "East"
        assertArrayEquals(new int[]{4, 0}, robot.getPos());
        assertEquals("East", robot.getDir());

        // step(2), step(1), step(4)
        robot.step(2);
        robot.step(1);
        robot.step(4);

        // getPos() -> [1, 2], getDir() -> "West"
        assertArrayEquals(new int[]{1, 2}, robot.getPos());
        assertEquals("West", robot.getDir());
    }

    @Test
    void ng1() {
        // 1. ["Robot", [8, 2]]
        Robot robot = new Robot(8, 2);

        // 2. ["step", [17]]
        robot.step(17);

        // 3. ["getPos"] -> [1, 0]
        assertArrayEquals(new int[]{1, 0}, robot.getPos());

        // 4. ["getDir"] -> "East"
        assertEquals("East", robot.getDir());

        // 5. ["step", [21]]
        robot.step(21);

        // 6. ["getPos"] -> [6, 0]
        assertArrayEquals(new int[]{6, 0}, robot.getPos());

        // 7. ["getDir"] -> "East"
        assertEquals("East", robot.getDir());

        // 8. ["step", [22]], 9. ["step", [34]]
        robot.step(22);
        robot.step(34);

        // 10. ["getPos"] -> [1, 1]
        assertArrayEquals(new int[]{1, 1}, robot.getPos());

        // 11. ["getDir"] -> "West"
        assertEquals("West", robot.getDir());

        // 12. ["step", [1]], 13. ["step", [46]], 14. ["step", [35]]
        robot.step(1);
        robot.step(46);
        robot.step(35);

        // 15. ["getPos"] -> [0, 0]
        assertArrayEquals(new int[]{0, 0}, robot.getPos());

        // 16. ["getDir"] -> "South" (ここが期待値のポイント)
        assertEquals("South", robot.getDir());

        // 17. ["step", [44]], 18. ["step", [14]], 19. ["step", [31]]
        robot.step(44);
        robot.step(14);
        robot.step(31);

        // 20. ["getPos"] -> [6, 1]
        assertArrayEquals(new int[]{6, 1}, robot.getPos());

        // 21. ["getDir"] -> "West"
        assertEquals("West", robot.getDir());

        // 22. ["step", [50]]
        robot.step(50);
    }
}