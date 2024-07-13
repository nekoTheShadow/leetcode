namespace robot_collisions.Tests;

[TestClass()]
public class SolutionTests
{
    [TestMethod()]
    public void Example1()
    {
        var actual = new Solution().SurvivedRobotsHealths(new int[] { 5, 4, 3, 2, 1 }, new int[] { 2, 17, 9, 15, 10 }, "RRRRR");
        var expected = new List<int> { 2, 17, 9, 15, 10 };
        CollectionAssert.AreEqual(expected, actual.ToArray());
    }

    [TestMethod()]
    public void Example2()
    {
        var actual = new Solution().SurvivedRobotsHealths(new int[] { 3, 5, 2, 6 }, new int[] { 10, 10, 15, 12 }, "RLRL");
        var expected = new List<int> { 14 };
        CollectionAssert.AreEqual(expected, actual.ToArray());
    }

    [TestMethod()]
    public void Example3()
    {
        var actual = new Solution().SurvivedRobotsHealths(new int[] { 1, 2, 5, 6 }, new int[] { 10, 10, 11, 11 }, "RLRL");
        var expected = new List<int> { };
        CollectionAssert.AreEqual(expected, actual.ToArray());
    }
}