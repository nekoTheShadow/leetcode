using most_stones_removed_with_same_row_or_column;
using System.Text.RegularExpressions;

int[][] ToMatrix(string s)
{
    return Regex.Matches(s, @"\[([0-9]*),([0-9]*)\]")
        .Cast<Match>()
        .Select(m => new int[] { int.Parse(m.Groups[1].Value), int.Parse(m.Groups[2].Value) })
        .ToArray();
}

var s = new Solution();
Console.WriteLine(s.RemoveStones(ToMatrix("[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]")));
Console.WriteLine(s.RemoveStones(ToMatrix("[[0,0],[0,2],[1,1],[2,0],[2,2]]")));
Console.WriteLine(s.RemoveStones(ToMatrix("[[0,0]]")));
