using System.Text.RegularExpressions;

namespace number_of_atoms;
public class Solution
{
    public string CountOfAtoms(string formula)
    {
        var tokens = Regex.Matches(formula, @"([A-Z]{1}[a-z]*|[0-9]+|[\(\)])").Select(match => match.Value).ToList();
        var n = tokens.Count;

        var stack = new Stack<string>();
        int i = 0;
        while (i < n)
        {
            var t = tokens[i];
            if (t == ")")
            {
                var buf = new List<string>();
                string u;
                while ((u = stack.Pop()) != "(")
                {
                    buf.Add(u);
                }
                buf.Reverse();


                int count;
                if (i + 1 < n && IsDigit(tokens[i + 1]))
                {
                    count = int.Parse(tokens[i + 1]);
                    i += 2;
                }
                else
                {
                    count = 1;
                    i += 1;
                }

                foreach (var v in Eval(buf, count))
                {
                    stack.Push(v);
                }
            }
            else
            {
                stack.Push(t);
                i++;
            }
        }

        return ToFormula(stack);
    }

    private string ToFormula(Stack<string> stack)
    {
        var tokens = stack.Reverse().ToList();
        var i = 0;
        var n = tokens.Count;
        var dict = new Dictionary<string, int>();
        while (i < n)
        {
            var t = tokens[i];
            int c;
            if (i + 1 < n && IsDigit(tokens[i + 1]))
            {
                c = int.Parse(tokens[i + 1]);
                i += 2;
            }
            else
            {
                c = 1;
                i += 1;
            }
            dict[t] = dict.ContainsKey(t) ? dict[t] + c : c;
        }
        return string.Join("", dict.Keys.Order().Select(k => dict[k] == 1 ? $"{k}" : $"{k}{dict[k]}"));
    }

    private List<string> Eval(List<string> tokens, int count)
    {
        var evaled = new List<string>();
        var i = 0;
        var n = tokens.Count;
        while (i < n)
        {
            if (i + 1 < n && IsDigit(tokens[i + 1]))
            {
                evaled.Add(tokens[i]);
                evaled.Add((int.Parse(tokens[i + 1]) * count).ToString());
                i += 2;
            }
            else
            {
                evaled.Add(tokens[i]);
                evaled.Add(count.ToString());
                i++;
            }
        }
        return evaled;
    }

    private bool IsDigit(string s)
    {
        return Regex.IsMatch(s, @"^[0-9]*$");
    }
}