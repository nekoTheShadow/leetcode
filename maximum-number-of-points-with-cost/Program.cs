using maximum_number_of_points_with_cost;

void Example01()
{
    var points = new int[][] { new int[] { 1, 2, 3 }, new int[] { 1, 5, 1 }, new int[] { 3, 1, 1 } };
    Console.WriteLine(new Solution().MaxPoints(points));
}

void Example02()
{
    var points = new int[][] { new int[] { 1, 5 }, new int[] { 2, 3 }, new int[] { 4, 2 } };
    Console.WriteLine(new Solution().MaxPoints(points));
}

Example01();
Example02();