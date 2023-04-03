package boats_to_save_people;

import java.util.TreeMap;

public class Solution20230403 {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int person : people) {
            tm.put(person, tm.getOrDefault(person, 0)+1);
        }
        
        int ans = 0;
        while (!tm.isEmpty()) {
            ans++;
            
            Integer a = tm.lastKey();
            tm.put(a, tm.get(a)-1);
            if (tm.get(a)==0) {
                tm.remove(a);
            }
            
            Integer b = tm.floorKey(limit-a);
            if (b!=null) {
                tm.put(b, tm.get(b)-1);
                if (tm.get(b)==0) {
                    tm.remove(b);
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution20230403().numRescueBoats(new int[] {1, 2}, 3));
        System.out.println(new Solution20230403().numRescueBoats(new int[] {3,2,2,1}, 3));
        System.out.println(new Solution20230403().numRescueBoats(new int[] {3,5,3,4}, 5));
    }
}
