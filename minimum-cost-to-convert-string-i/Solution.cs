namespace minimum_cost_to_convert_string_i;

public class Solution
{
    public long MinimumCost(string source, string target, char[] original, char[] changed, int[] cost)
    {
        var inf = long.MaxValue / 2 - 1;

        var dist = new long[26, 26];
        for (var i = 0; i < 26; i++)
        {
            for (var j = 0; j < 26; j++)
            {
                if (i == j)
                {
                    dist[i, j] = 0;
                }
                else
                {
                    dist[i, j] = inf;
                }

            }
        }
        for (var i = 0; i < original.Length; i++)
        {
            dist[original[i] - 'a', changed[i] - 'a'] = Math.Min(dist[original[i] - 'a', changed[i] - 'a'], cost[i]);
        }

        for (var k = 0; k < 26; k++)
        {
            for (var i = 0; i < 26; i++)
            {
                for (var j = 0; j < 26; j++)
                {
                    dist[i, j] = Math.Min(dist[i, j], dist[i, k] + dist[k, j]);
                }
            }
        }

        long ret = 0;
        for (var i = 0; i < source.Length; i++)
        {
            if (dist[source[i] - 'a', target[i] - 'a'] == inf)
            {
                return -1;
            }
            ret += dist[source[i] - 'a', target[i] - 'a'];
        }
        return ret;
    }
}
