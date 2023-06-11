package snapshot_array;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SnapshotArray {
    private List<TreeMap<Integer, Integer>> treeMaps;
    private int snapId;
    
    public SnapshotArray(int length) {
        this.treeMaps = IntStream.range(0, length).mapToObj(unused -> new TreeMap<Integer, Integer>()).collect(Collectors.toList());
        this.snapId = 0;
    }
    
    public int snap() {
        return this.snapId++;
    }
    
    public void set(int index, int val) {
        this.treeMaps.get(index).put(snapId, val);
    }
    
    public int get(int index, int snap_id) {
        var e = treeMaps.get(index).floorEntry(snap_id);
        if (e==null) {
            return 0;
        } else {
            return e.getValue();
        }
    }
}
