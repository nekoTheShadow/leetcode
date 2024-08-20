namespace stone_game_ii;

public class Solution
{
    public int StoneGameII(int[] piles)
    {
        this.piles = piles;
        this.memo = new Dictionary<(int, int, string), (int, int)>();
        var (alice, bob) = this.Simulate(0, 1, "Alice");
        return alice;
    }

    private int[] piles;
    private Dictionary<(int, int, string), (int, int)> memo;

    private (int, int) Simulate(int cur, int m, string who)
    {
        if (cur == this.piles.Length)
        {
            return (0, 0);
        }

        var key = (cur, m, who);
        if (this.memo.ContainsKey(key))
        {
            return this.memo[key];
        }


        int aliceMax = -1;
        int bobMax = -1;

        for (int x = 1; x <= 2 * m; x++)
        {
            int y = cur + x;
            if (this.piles.Length < y)
            {
                break;
            }

            int total = 0;
            for (int i = cur; i < y; i++)
            {
                total += this.piles[i];
            }

            if (who == "Alice")
            {
                var (alice, bob) = this.Simulate(y, Math.Max(m, x), "Bob");
                if (aliceMax < alice + total)
                {
                    aliceMax = alice + total;
                    bobMax = bob;
                }
            }
            else
            {
                var (alice, bob) = this.Simulate(y, Math.Max(m, x), "Alice");
                if (bobMax < bob + total)
                {
                    bobMax = bob + total;
                    aliceMax = alice;
                }
            }
        }

        this.memo[key] = (aliceMax, bobMax);
        return (aliceMax, bobMax);
    }
}