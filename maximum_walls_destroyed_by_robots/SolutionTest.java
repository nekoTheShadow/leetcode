package maximum_walls_destroyed_by_robots;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void testExample1() {
        Solution sol = new Solution();
        int[] robots = {4};
        int[] distance = {3};
        int[] walls = {1, 10};

        int result = sol.maxWalls(robots, distance, walls);

        // ロボット(4)が左に3移動 -> [1, 4]の壁(1)を破壊
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testExample2() {
        Solution sol = new Solution();
        int[] robots = {10, 2};
        int[] distance = {5, 1};
        int[] walls = {5, 2, 7};

        int result = sol.maxWalls(robots, distance, walls);

        // ロボット(10)が左に5 -> [5, 10]の壁(5, 7)を破壊
        // ロボット(2)が左に1 -> [1, 2]の壁(2)を破壊
        // 合計3枚
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testExample3() {
        Solution sol = new Solution();
        int[] robots = {1, 2};
        int[] distance = {100, 1};
        int[] walls = {10};

        int result = sol.maxWalls(robots, distance, walls);

        // ロボット(1)が右に撃とうとするが、ロボット(2)に遮られる
        // 壁(10)には届かない
        assertThat(result).isEqualTo(0);
    }
}