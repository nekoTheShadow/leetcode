namespace sort_array_by_increasing_frequency;

public class Solution
{
    public int[] FrequencySort(int[] nums)
    {
        return nums.GroupBy(x => x).Select(e => (Val: e.Key, Count: e.Count())).OrderBy(t => (t.Count, -t.Val)).SelectMany(t => Enumerable.Repeat(t.Val, t.Count)).ToArray();
    }
}