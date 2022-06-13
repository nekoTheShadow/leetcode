package triangle;

import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int x = (0<=j-1 && j-1<triangle.get(i-1).size()) ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int y = (0<=j && j<triangle.get(i-1).size()) ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(x, y));
            }
        }
        return Collections.min(triangle.get(triangle.size()-1));
    }
}
