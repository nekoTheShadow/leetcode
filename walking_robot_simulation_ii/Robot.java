package walking_robot_simulation_ii;

import java.util.List;

public class Robot {
    private final Tuple[] ts;
    private final int n;
    private int cur;
    private boolean moved;

    public Robot(int width, int height) {
        this.n = 2 * width + 2 * height - 4;
        this.ts = new Tuple[n];
        this.cur = 0;
        this.moved = false;

        List<Tuple> ds = List.of(
                new Tuple(1, 0, "East"),
                new Tuple(0, 1, "North"),
                new Tuple(-1, 0, "West"),
                new Tuple(0, -1, "South")
        );
        int x = 0;
        int y = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            Tuple d = ds.get(j);
            ts[i] = new Tuple(x, y, d.dir());
            if (!(0 <= x + d.x() && x + d.x() < width && 0 <= y + d.y() && y + d.y() < height)) {
                j++;
                d = ds.get(j);
            }
            x += d.x();
            y += d.y();
        }
    }

    public void step(int num) {
        moved = true;
        cur = (cur + num) % n;
    }

    public int[] getPos() {
        return new int[]{ts[cur].x(), ts[cur].y()};
    }

    public String getDir() {
        if (cur == 0) {
            return moved ? "South" : "East";
        } else {
            return ts[cur].dir();
        }
    }
}

record Tuple(int x, int y, String dir) {

}
