package water_bottles_ii;

public class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        while (numExchange <= numBottles) {
            total += numExchange;
            numBottles -= numExchange;
            numBottles++;
            numExchange++;
        }
        total += numBottles;
        return total;
    }
}