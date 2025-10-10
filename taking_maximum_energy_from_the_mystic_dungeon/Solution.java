package taking_maximum_energy_from_the_mystic_dungeon;

public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ret = Integer.MIN_VALUE;
        for (int i = n - 1; i >= n - k; i--) {
            int total = 0;
            for (int j = i; j >= 0; j -= k) {
                total += energy[j];
                ret = Math.max(ret, total);
            }
        }
        return ret;
    }
}
