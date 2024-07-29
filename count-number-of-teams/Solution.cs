namespace count_number_of_teams;
public class Solution
{
    public int NumTeams(int[] rating)
    {
        int s1 = Solve(rating);
        Array.Reverse(rating);
        return s1 + Solve(rating);
    }

    private int Solve(int[] rating)
    {
        var n = rating.Length;
        var dp = new int[n, 3];
        for (var i = 0; i < n; i++)
        {
            dp[i, 0] = 1;
        }

        for (var i = 0; i < n; i++)
        {
            for (var j = i+1; j < n; j ++)
            {
                if (rating[i] < rating[j])
                {
                    dp[j, 1] += dp[i, 0];
                    dp[j, 2] += dp[i, 1];
                }
            }
        }
        return Enumerable.Range(0, n).Sum(i => dp[i, 2]);
    } 
}