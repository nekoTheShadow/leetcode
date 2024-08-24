using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace find_the_closest_palindrome;

public class Solution
{
    public string NearestPalindromic(string n)
    {
        var lenN = n.Length;
        var i = lenN % 2 == 0 ? lenN / 2 - 1 : lenN / 2;
        var firstHalf = long.Parse(n.Substring(0, i + 1));
        var possibilities = new List<long>
        {
            this.halfToPalindrome(firstHalf, lenN%2==0),
            this.halfToPalindrome(firstHalf+1, lenN%2==0),
            this.halfToPalindrome(firstHalf-1, lenN%2==0),
            (long)Math.Pow(10, lenN-1) - 1,
            (long)Math.Pow(10, lenN)+1,
        };

        long nl = long.Parse(n);
        return possibilities.Where(p => p != nl).Order().MinBy(p => Math.Abs(p - nl)).ToString();
    }

    private long halfToPalindrome(long left, bool even)
    {
        var res = left;
        if (!even)
        {
            left = left / 10;
        }
        while (left > 0)
        {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
}
