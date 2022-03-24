package boats_to_save_people;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[] {1,2}, 3));
        System.out.println(new Solution().numRescueBoats(new int[] {3,2,2,1}, 3));
        System.out.println(new Solution().numRescueBoats(new int[] {3,5,3,4}, 5));
        
        System.out.println(new Solution().numRescueBoats(new int[] {2,4}, 5));
    }
    
    
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        Arrays.stream(people).forEach(v -> counter.put(v, counter.getOrDefault(v, 0)+1));

        int ans = 0;
        for (int x : people) {
            if (!counter.containsKey(x)) {
                continue;
            }
            
            Integer y = counter.floorKey(limit-x);
            if (y!=null && (y != x || counter.get(y) > 1)) {
                decrement(counter, y);
            }
            decrement(counter, x);
            ans++;
        }
        
        return ans;
    }
    
    private void decrement(TreeMap<Integer, Integer> counter, Integer key) {
        counter.put(key, counter.get(key)-1);
        if (counter.get(key) == 0) {
            counter.remove(key);
        }
    }
}
