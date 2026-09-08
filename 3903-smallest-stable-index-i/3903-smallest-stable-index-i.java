class Solution { 
    public int firstStableIndex(int[] nums, int k) {
        int max= 0;
        for(int i = 0; i < nums.length; i++ ){
            int min = nums[i];
            if(nums[i] > max) 
                max = nums[i];
            
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