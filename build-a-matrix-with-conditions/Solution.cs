namespace build_a_matrix_with_conditions;

public class Solution
{
    public int[][] BuildMatrix(int k, int[][] rowConditions, int[][] colConditions)
    {
        var r = Tsort(k, rowConditions);
        if (r == null)
        {
            return new int[][] { };
        }

        var c = Tsort(k, colConditions);
        if (c == null)
        {
            return new int[][] { };
        }

        var ret = Enumerable.Range(0, k).Select(unused => new int[k]).ToArray();
        for (var i = 1; i <= k; i++)
        {
            ret[r.IndexOf(i)][c.IndexOf(i)] = i;
        }
        return ret;
    }

    public List<int>? Tsort(int k, int[][] conditions)
    {
        var count = new int[k];
        var graph = Enumerable.Range(0, k).Select(i => new List<int>()).ToArray();
        foreach (var condition in conditions)
        {
            var a = condition[0]-1;
            var b = condition[1]-1;
            count[b]++;
            graph[a].Add(b);
        }

        var stack = new Stack<int>(Enumerable.Range(0, k).Where(i => count[i] == 0));
        var ret = new List<int>();
        while (stack.Count() > 0)
        {
            var cur = stack.Pop();
            ret.Add(cur+1);
            foreach (var nxt in graph[cur])
            {
                count[nxt]--;
                if (count[nxt] == 0)
                {
                    stack.Push(nxt);
                }
            }
        }

        if (count.All(v => v == 0))
        {
            return ret;
        }
        else
        {
            return null;
        }
    }
}
