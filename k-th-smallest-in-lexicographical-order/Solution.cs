namespace k_th_smallest_in_lexicographical_order;

public class Solution
{
    public int FindKthNumber(int n, int k)
    {
        return (int)Solve(n, k);
    }

    private long Solve(long n, long k)
    {
        long curr = 1;
        k--;
        while (k > 0)
        {
            long step = CountStep(n, curr, curr + 1);
            if (step <= k)
            {
                curr++;
                k -= step;
            }
            else
            {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private long CountStep(long n, long p1, long p2)
    {
        long step = 0;
        while (p1 <= n)
        {
            step += Math.Min(n + 1, p2) - p1;
            p1 *= 10;
            p2 *= 10;
        }
        return step;
    }
}