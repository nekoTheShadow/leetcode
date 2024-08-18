namespace ugly_number_ii;

public class Solution
{
    public int NthUglyNumber(int n)
    {
        var pq = new PriorityQueue<(long, long), long>();
        pq.Enqueue((1, 1), 1);

        for (int i = 0; i < n - 1; i++)
        {
            var (last, x) = pq.Dequeue();
            foreach (var y in new int[] { 2, 3, 5 })
            {
                if (last <= y)
                {
                    pq.Enqueue((y, y * x), y * x);
                }
            }
        }

        return (int)pq.Peek().Item2;
    }
}