package romanto_integer;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        ok("III", 3);
        ok("IV", 4);
        ok("IX", 9);
        ok("LVIII", 58);
        ok("MCMXCIV", 1994);
    }
    
    public static void ok(String s, int expected) {
        Solution solution = new Solution();
        int actual = solution.romanToInt(s);
        if (actual!=expected) {
            System.out.printf("%s: expected: %d, actual: %d%n", s, expected, actual);
        }
    }
    
    public int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        String[] romans = new String[] {"IV","IX","XL","XC","CD","CM","I","V","X","L","C","D","M"};
        int[] ints = new int[]{4,9,40,90,400,900,1,5,10,50,100,500,1000};
        
        int x = IntStream.range(0, romans.length).filter(i -> s.startsWith(romans[i])).findFirst().getAsInt();
        return ints[x] + romanToInt(s.substring(romans[x].length()));
    }
}
