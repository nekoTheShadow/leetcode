namespace most_stones_removed_with_same_row_or_column;
public class Solution
{
    public int RemoveStones(int[][] stones)
    {
        int n = stones.Length;

        var uf = new UnionFind(n);
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    uf.Union(i, j);
                }
            }
        }

        return n - Enumerable.Range(0, n).Select(x => uf.Find(x)).Distinct().Count();
    }
}

public class UnionFind
{
    private int[] parents;

    public UnionFind(int n)
    {
        this.parents = Enumerable.Range(0, n).ToArray();
    }

    public int Find(int x)
    {
        if (this.parents[x] != x)
        {
            this.parents[x] = this.Find(this.parents[x]);
        }
        return this.parents[x];
    }

    public void Union(int x, int y)
    {
        x = this.Find(x);
        y = this.Find(y);
        if (x != y)
        {
            this.parents[x] = y;
        }
    }
}
