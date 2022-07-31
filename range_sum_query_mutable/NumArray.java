package range_sum_query_mutable;

public class NumArray {
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[] {1, 3, 5});
        System.out.println(na.sumRange(0, 2));
        na.update(1, 2);
        System.out.println(na.sumRange(0, 2));
    }
    
    private int[] nums;
    private BIT bit;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        
        BIT bit = new BIT(nums.length);
        for (int i = 0; i < nums.length; i++) {
            bit.add(i+1, nums[i]);
        }
        this.bit = bit;
    }
    
    public void update(int index, int val) {
        bit.add(index+1, -nums[index]);
        nums[index] = val;
        bit.add(index+1, nums[index]);
    }
    
    public int sumRange(int left, int right) {
        return bit.sum(right+1) - bit.sum(left);
    }
    
    public class BIT {

        private int n;
        private int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n+1];
        }

        public int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += this.tree[i];
                i -= i & -i;
            }
            return s;
        }

        public void add(int i, int x) {
            while (i <= this.n) {
                this.tree[i] += x;
                i += i & -i;
            }
        }
    }
}
