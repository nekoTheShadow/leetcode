using System.Numerics;

namespace find_the_student_that_will_replace_the_chalk;
public class Solution
{
    public int ChalkReplacer(int[] chalk, int k)
    {
        var vals = chalk.Select(c => new BigInteger(c)).ToList();
        var x = new BigInteger(k) % vals.Aggregate((acc, val) => acc + val);

        int i = 0;
        while (vals[i] <= x)
        {
            x -= vals[i];
            i++;
        }
        return i;
    }
}