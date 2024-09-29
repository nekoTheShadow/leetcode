namespace all_oone_data_structure;

public class AllOne
{
    private Dictionary<string, int> counts;
    private SortedDictionary<int, HashSet<string>> words;
    public AllOne()
    {
        this.counts = new Dictionary<string, int>();
        this.words = new SortedDictionary<int, HashSet<string>>();
    }

    public void Inc(string key)
    {
        int count = this.counts.GetValueOrDefault(key, 0);
        this.counts[key] = count + 1;
        this.Move(count, count + 1, key);
    }

    public void Dec(string key)
    {
        int count = this.counts[key];
        if (count == 1)
        {
            this.counts.Remove(key);
        }
        else
        {
            this.counts[key] = count - 1;
        }
        this.Move(count, count - 1, key);
    }

    public string GetMaxKey()
    {
        if (this.IsEmpty())
        {
            return "";
        }
        return this.words.Last().Value.First();
    }

    public string GetMinKey()
    {
        if (this.IsEmpty())
        {
            return "";
        }

        return this.words.First().Value.First();
    }

    private bool IsEmpty()
    {
        return this.counts.Count == 0;
    }

    private void Move(int count1, int count2, string word)
    {
        if (this.words.ContainsKey(count1))
        {
            this.words[count1].Remove(word);
            if (this.words[count1].Count == 0)
            {
                this.words.Remove(count1);
            }
        }

        if (!this.words.ContainsKey(count2))
        {
            this.words[count2] = new HashSet<string>();
        }
        this.words[count2].Add(word);

        if (this.words.ContainsKey(0))
        {
            this.words.Remove(0);
        }
    }
}