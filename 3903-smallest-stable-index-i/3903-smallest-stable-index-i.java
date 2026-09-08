class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++ ){
            int max= 0;
            int min = nums[i];
            for(int j =0; j <= i; j++){
                if(nums[j] > max) 
                max = nums[j];
            }
            for(int j = i; j < nums.length; j++){
                if(nums[j] < min)
                min = nums[j];
            }
            int instabilityScore = max - min;
            if(instabilityScore <= k ) return i;
        }
        return -1;
    }
}