package groups_of_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().groupStrings(new String[] {"a","b","ab","cde"})));
        System.out.println(Arrays.toString(new Solution().groupStrings(new String[] {"a","ab","abc"})));
        System.out.println(Arrays.toString(new Solution().groupStrings(new String[] {"web","a","te","hsx","v","k","a","roh"})));
    }
    
    public int[] groupStrings(String[] words) {
        UnionFind uf = new UnionFind(words.length);
        
        Map<Integer, Integer> bits = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int bit = 0;
            for (char ch : words[i].toCharArray()) {
                bit |= 1 << (ch - 'a');
            }
            if (bits.containsKey(bit)) {
                uf.union(bits.get(bit), i);
            } else {
                bits.put(bit, i);
            }
        }
        
        
        for (int bit : bits.keySet()) {
            // 追加
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int x = ch - 'a';
                if ((bit & (1 << x)) == 0) {
                    int nextBit = bit | (1 << x);
                    if (bits.containsKey(nextBit)) {
                        uf.union(bits.get(bit), bits.get(nextBit));
                    }
                }
            }
            
            // 削除
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int x = ch - 'a';
                if ((bit & (1 << x)) != 0) {
                    int nextBit = bit & (~(1 << x));
                    if (bits.containsKey(nextBit)) {
                        uf.union(bits.get(bit), bits.get(nextBit));
                    }
                }
            }
            
            for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
                for (char ch2 = (char)(ch1 + 1); ch2 <= 'z'; ch2++) {
                    int x1 = ch1 - 'a';
                    int x2 = ch2 - 'a';
                    if ((bit&(1<<x1))!=0 && (bit&(1<<x2))==0) {
                        int nextBit = (bit & (~(1 << x1))) | (1 << x2);
                        if (bits.containsKey(nextBit)) {
                            uf.union(bits.get(bit), bits.get(nextBit));
                        }
                    }
                }
            }
        }
        
        int[] ans = new int[2];
        for (int i = 0; i < words.length; i++) {
            if (uf.find(i) == i) {
                ans[0]++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            ans[1] = Math.max(ans[1], uf.size(i));
        }
        return ans;
    }
    
    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = IntStream.range(0, n).toArray();
            this.size = new int[n];
            Arrays.fill(this.size, 1);
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return ;
            }

            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }

        }

        public int size(int x) {
            return size[find(x)];
        }
    }
}
