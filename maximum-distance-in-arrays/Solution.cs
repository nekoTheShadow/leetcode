namespace maximum_distance_in_arrays;

public class Solution
{
    public int MaxDistance(IList<IList<int>> arrays)
    {
        var min1 = int.MaxValue;
        var min2 = int.MaxValue; // min1 < min2
        var max1 = int.MinValue;
        var max2 = int.MinValue; // max1 > max2

        foreach (var array in arrays)
        {
            var min = array.First();
            var max = array.Last();

            if (min <= min1)
            {
                min2 = min1;
                min1 = min;
            }
            else if (min <= min2)
            {
                min2 = min;
            }

            if (max1 <= max)
            {
                max2 = max1;
                max1 = max;
            }
            else if (max2 < max)
            {
                max2 = max;
            }
        }

        int d = 0;
        foreach (var array in arrays)
        {
            var min = array.First();
            var max = array.Last();

            var max3 = (max1 == max) ? max2 : max1;
            d = Math.Max(d, Math.Abs(max3 - min));

            var min3 = (min1 == min) ? min2 : min1;
            d = Math.Max(d, Math.Abs(min3 - max));
        }

        return d;

    }
}
