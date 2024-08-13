namespace combination_sum_ii;
public class Solution
{
    public IList<IList<int>> CombinationSum2(int[] candidates, int target)
    {
        var pairs = candidates.GroupBy(x => x).Select(t => (t.Key, t.Count())).ToList();
        var ret = new List<IList<int>>();
        dfs(ret, pairs, new Stack<(int, int)>(), target, 0);
        return ret;
    }


    public void dfs(IList<IList<int>> ret, List<(int, int)> pairs, Stack<(int, int)> stack, int target, int cur)
    {
        if (target == 0)
        {
            ret.Add(stack.SelectMany(t => Enumerable.Repeat(t.Item1, t.Item2)).ToList());
            return;
        }

        if (pairs.Count == cur)
        {
            return;
        }

        var (x, c) = pairs[cur];
        for (int i = 1; i <= c; i++)
        {
            if (target - x * i >= 0)
            {
                stack.Push((x, i));
                dfs(ret, pairs, stack, target - x * i, cur + 1);
                stack.Pop();
            }
        }
        dfs(ret, pairs, stack, target, cur + 1);
    }

}