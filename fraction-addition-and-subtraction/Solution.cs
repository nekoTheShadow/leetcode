using System.Text.RegularExpressions;

namespace fraction_addition_and_subtraction;
public class Solution
{
    public string FractionAddition(string expression)
    {
        return Regex.Matches(expression, "([+-]*[0-9]+)/([0-9]+)")
                .Select((Match m) => new Fraction(long.Parse(m.Groups[1].Value), long.Parse(m.Groups[2].Value)))
                .Aggregate((acc, f) => acc + f)
                .ToString();
    }
}

public class Fraction
{
    private long numerator; // 分子
    private long denominator; // 分母

    public Fraction(long numerator, long denominator)
    {
        var gcd = Gcd(Math.Abs(numerator), Math.Abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public static Fraction operator +(Fraction a, Fraction b)
    {
        var denominator = Lcm(a.denominator, b.denominator);
        var numerator1 = a.numerator * (denominator / a.denominator);
        var numerator2 = b.numerator * (denominator / b.denominator);
        return new Fraction(numerator1 + numerator2, denominator);
    }

    public override string ToString()
    {
        return $"{this.numerator}/{this.denominator}";
    }

    private static long Lcm(long x, long y)
    {
        return (x * y) / Gcd(x, y);
    }

    private static long Gcd(long x, long y)
    {
        if (x < y)
        {
            var tmp = x;
            x = y;
            y = tmp;
        }

        while (y > 0)
        {
            var mod = x % y;
            x = y;
            y = mod;
        }
        return x;
    }
}
