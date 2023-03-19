package design_add_and_search_words_data_structure;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private Node root;
    
    public WordDictionary() {
        this.root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.nexts.containsKey(c)) {
                cur = cur.nexts.get(c);
            } else {
                Node next = new Node(c);
                cur.nexts.put(c, next);
                cur = next;
            }
        }
        cur.accept = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, this.root);
    }
    
    public boolean search(String word, int k, Node node) {
        if (word.length() == k) {
            return node.accept;
        }
        
        char c = word.charAt(k);
        if (c == '.') {
            return node.nexts.values().stream().anyMatch(next -> search(word, k+1, next));
        } else {
            return node.nexts.containsKey(c) && search(word, k+1, node.nexts.get(c));
        }
    }
    
    public static class Node {
        public char c;
        public boolean accept;
        public Map<Character, Node> nexts;
        
        public Node(char c) {
            this.c = c;
            this.accept = false;
            this.nexts = new HashMap<>();
        }
    }
    
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
