package replace_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie<String> trie = new Trie<>();
        for (String v : dictionary) {
        	trie.insert(v, v);
        }
        
        return Pattern.compile(" ").splitAsStream(sentence).map(v -> {
        	List<String> w = trie.query(v);
        	return w.isEmpty() ? v : w.get(0);
        }).collect(Collectors.joining(" "));
        
    }
    
    public static class Trie<T> {
    	private Node<T> root;
    	
    	public Trie() {
    		this.root = new Node<T>();
    	}
    	
    	public void insert(String key, T value) {
    		Node<T> node = root;
    		for (char ch : key.toCharArray()) {
    			if (!node.children.containsKey(ch)) {
    				node.children.put(ch, new Node<T>());
    			}
    			node = node.children.get(ch);
    		}
    		node.value = value;
    	}
    	
    	// trieに登録されている文字をsとする
    	// key.start_with(s)を満たす、すべてのvalueを返す
    	public List<T> query(String key) {
    		List<T> values = new ArrayList<>();
    		Node<T> node = root;
    		for (char ch : key.toCharArray()) {
    			if (node.value != null) {
    				values.add(node.value);
    			}
    			if (!node.children.containsKey(ch)) {
    				break;
    			}
    			node = node.children.get(ch);
    		}
    		return values;
    	}
    	
    	private static class Node<T> {
    		private Map<Character, Node<T>> children;
    		private T value;
    		
    		public Node() {
    			this.children = new HashMap<>();
    			this.value = null;
    		}
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
		System.out.println(new Solution().replaceWords(List.of("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
	}
}


