using lexicographical_numbers;

void Run(int n)
{
    var s = new Solution();
    var numbers = s.LexicalOrder(n);
    var line = String.Join(",", numbers);
    Console.WriteLine(line);
}



Run(13);
Run(2);