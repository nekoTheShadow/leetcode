namespace lexicographical_numbers;

public class Solution
{
    public IList<int> LexicalOrder(int n)
    {
        this.numbers = new List<int>();
        this.n = n;

        for (int i = 1; i < 10; i++)
        {
            this.Dfs(i);
        }

        return this.numbers;
    }

    private List<int> numbers;
    private int n;

    private void Dfs(int x)
    {
        if (n < x)
        {
            return;
        }

        this.numbers.Add(x);
        for (int i = 0; i < 10; i++)
        {
            this.Dfs(x * 10 + i);
        }
    }
}