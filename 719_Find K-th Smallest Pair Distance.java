class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = nums[1] - nums[0];
        int hi = nums[nums.length-1] - nums[0];
        for(int i = 1; i < nums.length; i++)
            lo = Math.min(lo,nums[i]-nums[i-1]);
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(countPairs(nums,mid) < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    
    private int countPairs(int[] nums,int mid){
        int res = 0;
        for(int i = 0; i < nums.length-1; i++){
            //int j = i + 1;
            //while(j < nums.length && nums[j] - nums[i] <= mid)
            //    j++;
            int j = upperBound(nums,i,nums[i]+mid);
            res += j - i - 1;
        }
        return res;
    }
    
    private int upperBound(int[] nums,int start,int key){
        if(nums[nums.length-1] <= key)
            return nums.length;
        int lo = start;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= key)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}