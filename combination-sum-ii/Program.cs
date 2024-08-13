var s = new combination_sum_ii.Solution();

foreach(var item in s.CombinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8))
{
    Console.WriteLine(String.Join(", ", item));
}


foreach (var item in s.CombinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5))
{
    Console.WriteLine(String.Join(", ", item));
}
