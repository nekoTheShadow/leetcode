package lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int capacity;
    private int minFreq;
    
    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        LinkedHashSet<Integer> keys = frequencies.get(node.freq);
        keys.remove(key);
        if (minFreq == node.freq && keys.isEmpty()) {
            minFreq++;
        }
        
        update(key, node.freq+1, node.value);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return ;
        }
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.put(key, new Node(node.freq, value));
            get(key);
        } else {
            if (capacity == cache.size()) {
                LinkedHashSet<Integer> keys = frequencies.get(minFreq);
                int deleteKey = keys.iterator().next();
                cache.remove(deleteKey);
                keys.remove(deleteKey);
            }
            minFreq = 1;
            update(key, 1, value);
        }
    }
    
    private void update(int key, int freq, int value) {
        cache.put(key, new Node(freq, value));
        frequencies.computeIfAbsent(freq, unused -> new LinkedHashSet<>()).add(key);
    }
    
    public class Node {
        private int value;
        private int freq;
        
        public Node(int freq, int value) {
            this.value = value;
            this.freq = freq;
        }
    }
}
