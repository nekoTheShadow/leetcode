package lfu_cache;

public class Main {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   
        lfu.put(2, 2);   
        System.out.println(lfu.get(1)); // return 1
        lfu.put(3, 3);   
        System.out.println(lfu.get(2)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        lfu.put(4, 4);   
        System.out.println(lfu.get(1)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3
        System.out.println(lfu.get(4)); // return 4
                        
    }
}
