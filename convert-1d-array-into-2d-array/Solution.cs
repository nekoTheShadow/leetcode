namespace convert_1d_array_into_2d_array;

public class Solution
{
    public int[][] Construct2DArray(int[] original, int m, int n)
    {
        int len = original.Length;
        if (len != m * n)
        {
            return new int[][] { };
        }

        int[][] a = new int[m][];
        for (int x = 0; x < m; x++)
        {
            a[x] = new int[n];
        }
        for (int x = 0; x < len; x++)
        {
            a[x / n][x % n] = original[x];
        }
        return a;
    }
}