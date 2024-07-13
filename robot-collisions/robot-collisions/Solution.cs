namespace robot_collisions;
public class Solution
{
    public IList<int> SurvivedRobotsHealths(int[] positions, int[] healths, string directions)
    {
        var n = positions.Length;
        var indices = Enumerable.Range(0, n).OrderBy(i => positions[i]).ToList();
        var stack = new Stack<int>();
        foreach (var current_index in indices)
        {
            if (directions[current_index] == 'R')
            {
                stack.Push(current_index);
            } else
            {
                while (stack.Count > 0 && healths[current_index] > 0)
                {
                    var top_index = stack.Pop();
                    if (healths[top_index] > healths[current_index])
                    {
                        healths[top_index]--;
                        healths[current_index] = 0;
                        stack.Push(top_index);
                    } else if (healths[top_index] < healths[current_index]) 
                    {
                        healths[top_index] = 0;
                        healths[current_index]--;
                    } else
                    {
                        healths[top_index] = 0;
                        healths[current_index] = 0;
                    }
                }
            }
        }

        return Enumerable.Range(0, n).Where(i => healths[i] > 0).Select(i => healths[i]).ToList();
    }
}