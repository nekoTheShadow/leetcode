namespace count_number_of_teams;

public class Program
{
    static void Main(string[] args)
    {
        var s = new Solution();
        Console.WriteLine(s.NumTeams(new int[] { 2, 5, 3, 4, 1 }));
        Console.WriteLine(s.NumTeams(new int[] { 2, 1, 3 }));
        Console.WriteLine(s.NumTeams(new int[] { 1, 2, 3, 4 }));
    }
}
