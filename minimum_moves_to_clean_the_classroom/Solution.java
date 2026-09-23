package minimum_moves_to_clean_the_classroom;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int minMoves(String[] classroom, int energy) {
        int h = classroom.length;
        int w = classroom[0].length();

        int startX = -1;
        int startY = -1;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (classroom[x].charAt(y) == 'S') {
                    startX = x;
                    startY = y;
                }
            }
        }

        int[][] ids = new int[h][w];
        int count = 0;
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                if (classroom[x].charAt(y) == 'L') {
                    ids[x][y] = count++;
                }
            }
        }

        Queue<State> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[h][w][1 << count][energy + 1];
        queue.add(new State(startX, startY, 0, energy));
        visited[startX][startY][0][energy] = true;

        int steps = 0;

        int[][] directions = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                State current = queue.poll();

                if (current.mask() == (1 << count) - 1) {
                    return steps;
                }
                if (current.energy() == 0) {
                    continue;
                }

                for (int[] direction : directions) {
                    int nextX = current.x() + direction[0];
                    int nextY = current.y() + direction[1];
                    int nextMask = current.mask();
                    int nextEnergy = current.energy() - 1;

                    if (!(0 <= nextX && nextX < h && 0 <= nextY && nextY < w)) {
                        continue;
                    }
                    if (classroom[nextX].charAt(nextY) == 'X') {
                        continue;
                    }

                    if (classroom[nextX].charAt(nextY) == 'L') {
                        nextMask |= 1 << ids[nextX][nextY];
                    }
                    if (classroom[nextX].charAt(nextY) == 'R') {
                        nextEnergy = energy;
                    }

                    if (!visited[nextX][nextY][nextMask][nextEnergy]) {
                        visited[nextX][nextY][nextMask][nextEnergy] = true;
                        queue.add(new State(nextX, nextY, nextMask, nextEnergy));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}

record State(int x, int y, int mask, int energy) {
}