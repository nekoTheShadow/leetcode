namespace range_sum_of_sorted_subarray_sums;

public class Solution
{
    public int RangeSum(int[] nums, int n, int left, int right)
    {
        var totals = new List<int>();
        for (int i = 0; i < n; i++)
        {
            int total = 0;
            for (int j = i; j < n; j++)
            {
                
                total += nums[j];
                totals.Add(total);
            }
        }

        totals.Sort();

        int ret = 0;
        for (int i = left - 1; i < right; i++)
        {
            ret += totals[i];
            ret %= 1000000000 + 7;
        }
        return ret;
    }
}
