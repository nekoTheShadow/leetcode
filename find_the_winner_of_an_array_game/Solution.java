package find_the_winner_of_an_array_game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[] {2,1,3,5,4,6,7}, 2));
        System.out.println(new Solution().getWinner(new int[] {3,2,1}, 10));
    }
    
    public int getWinner(int[] arr, int k) {
        if (arr.length <= k) {
            return Arrays.stream(arr).max().getAsInt();
        }
        
        LinkedList<Integer> a = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));
        int winner = -1;
        int winCount = 0;
        while (winCount < k) {
            int x = a.get(0) < a.get(1) ? 1 : 0;
            if (winner != a.get(x)) {
                winner = a.get(x);
                winCount = 0;
            }
            winCount++;
            a.add(a.remove(1-x));
        }
        return winner;
    }
}
