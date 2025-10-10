package find_the_minimum_amount_of_time_to_brew_potions;

import java.util.Arrays;

public class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] skills = Arrays.stream(skill).mapToLong(v -> (long) v).toArray();
        long[] manas = Arrays.stream(mana).mapToLong(v -> (long) v).toArray();
        long[] frees = new long[skill.length];
        for (long m : manas) {
            long ng = -1;
            long ok = (long) 1e15;
            while (Math.abs(ok - ng) > 1) {
                long mi = (ok + ng) / 2;
                if (check(skills, m, frees, mi)) {
                    ok = mi;
                } else {
                    ng = mi;
                }
            }

            long time = ok;
            for (int i = 0; i < frees.length; i++) {
                time += m * skill[i];
                frees[i] = time;
            }
        }

        return frees[frees.length - 1];
    }

    private boolean check(long[] skills, long mana, long[] frees, long start) {
        long time = start;
        for (int i = 0; i < skills.length; i++) {
            if (frees[i] > time) {
                return false;
            }
            time += skills[i] * mana;
        }
        return true;
    }
}