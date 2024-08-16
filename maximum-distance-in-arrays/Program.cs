using maximum_distance_in_arrays;

var s = new Solution();
Console.WriteLine(s.MaxDistance(new List<IList<int>> { new List<int> { 1, 2, 3 }, new List<int> { 4, 5 }, new List<int> { 1, 2, 3 } }));
Console.WriteLine(s.MaxDistance(new List<IList<int>> { new List<int> { 1 }, new List<int> { 1 } }));