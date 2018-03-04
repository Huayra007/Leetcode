class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0;
        int hi = 0;
        for(int n : nums){
            if(n > lo) lo = n;
            hi += n;
        }
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(valid(nums,mid,m))
                hi = mid;
            else 
                lo = mid + 1;
        }
        return lo;
    }
    
    private boolean valid(int[] nums,int mid,int m){
        int count = 1;
        int sum = 0;
        for(int n : nums){
            sum += n;
            if(sum > mid){
                count++;
                sum = n;
            }
            if(count > m)
                return false;
        }
        return true;
    }
}