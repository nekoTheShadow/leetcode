
using convert_1d_array_into_2d_array;

void prettyPrint(int[][] a)
{
    if (a.Length == 0)
    {
        Console.WriteLine("[]");
    }

    foreach (int[] row in a)
    {
        Console.WriteLine("[" + String.Join(", ", row) + "]");
    }
}

var s = new Solution();
prettyPrint(s.Construct2DArray(new int[] { 1, 2, 3, 4 }, 2, 2));
prettyPrint(s.Construct2DArray(new int[] { 1, 2, 3 }, 1, 3));
prettyPrint(s.Construct2DArray(new int[] { 1, 2 }, 1, 1));
