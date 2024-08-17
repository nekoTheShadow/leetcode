namespace maximum_number_of_points_with_cost;
public class Solution
{
    public long MaxPoints(int[][] points)
    {
        var n = points[0].Length;
        var dp = new long[n];

        foreach (var row in points)
        {
            var l = new long[n];
            var r = new long[n];
            var lmax = 0L;
            var rmax = 0L;
            for (int i = 0; i < n; i++)
            {
                lmax = Math.Max(lmax - 1, dp[i]);
                l[i] = lmax;
            }
            for (int i = n - 1; i >= 0; i--)
            {
                rmax = Math.Max(rmax - 1, dp[i]);
                r[i] = rmax;
            }

            for (int i = 0; i < n; i++)
            {
                dp[i] = Math.Max(l[i], r[i]) + row[i];
            }
        }

        return dp.Max();
    }
}