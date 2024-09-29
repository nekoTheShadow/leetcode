using all_oone_data_structure;

var allOne = new AllOne();
allOne.Inc("hello");
allOne.Inc("hello");
Console.WriteLine(allOne.GetMaxKey());
Console.WriteLine(allOne.GetMinKey());
allOne.Inc("leet");
Console.WriteLine(allOne.GetMaxKey());
Console.WriteLine(allOne.GetMinKey());