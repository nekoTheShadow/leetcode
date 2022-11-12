package find_median_from_data_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
    
    private List<Integer> a;
    
    public MedianFinder() {
        this.a = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int v = Collections.binarySearch(a, num);
        if (v>=0) {
            a.add(v, num);
        } else {
            a.add(-(v+1), num);
        }
    }
    
    public double findMedian() {
        int n = a.size();
        if (n%2==0) {
            return (a.get(n/2-1)+a.get(n/2))/2.0;
        } else {
            return a.get(n/2);
        }
    }
}
