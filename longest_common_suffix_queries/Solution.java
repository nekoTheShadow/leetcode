package longest_common_suffix_queries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            trie.insert(reverse(wordsContainer[i]), i);
        }
        return Arrays.stream(wordsQuery).mapToInt(word -> trie.query(reverse(word))).toArray();
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

class Trie {
    private final Node root;

    Trie() {
        this.root = new Node();
    }

    void insert(String s, int idx) {
        Node node = this.root;
        if (s.length() < node.minLen) {
            node.minLen = s.length();
            node.idx = idx;
        }

        for (char ch : s.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Node());
            }
            node = node.children.get(ch);

            if (s.length() < node.minLen) {
                node.minLen = s.length();
                node.idx = idx;
            }
        }
    }

    int query(String s) {
        Node node = this.root;
        for (char ch : s.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                break;
            }
        }
        return node.idx;
    }

    class Node {
        Map<Character, Node> children;
        int minLen;
        int idx;

        Node() {
            this.children = new HashMap<>();
            this.minLen = Integer.MAX_VALUE;
            this.idx = Integer.MAX_VALUE;
        }
    }
}
