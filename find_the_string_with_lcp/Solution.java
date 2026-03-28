package find_the_string_with_lcp;

import java.util.stream.IntStream;

public class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        UnionFind uf = new UnionFind(n);

        // 同じ文字であるべき位置を Union-Find でまとめる
        for (int i = 0; i < n; i++) {
            // s[i..]とs[i..]のLCPはn-iになる
            if (lcp[i][i] != n - i) {
                return "";
            }

            for (int j = i + 1; j < n; j++) {
                // s[i..]とs[j..]のLCP
                // s[j..]とs[i..]のLCP は一致する
                if (lcp[i][j] != lcp[j][i]) {
                    return "";
                }
                if (lcp[i][j] > 0) {
                    uf.union(i, j);
                }
            }
        }

        // 各グループに最小の文字を割り当てる
        char[] chars = new char[n];
        char ch = 'a';
        for (int i = 0; i < n; i++) {
            int j = uf.find(i);
            if (chars[j] == '\0') {
                if (ch > 'z') {
                    return "";
                }
                chars[j] = ch++;
            }
            chars[i] = chars[j];
        }


        // LCP を再計算して検証
        int[][] check = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (chars[i] == chars[j]) {
                    if (i == n - 1 || j == n - 1) {
                        check[i][j] = 1;
                    } else {
                        check[i][j] = check[i + 1][j + 1] + 1;
                    }
                } else {
                    check[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != check[i][j]) {
                    return "";
                }
            }
        }

        return new String(chars);
    }
}

class UnionFind {
    private final int[] parents;

    public UnionFind(int n) {
        this.parents = IntStream.range(0, n).toArray();
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[x] = y;
        }
    }
}