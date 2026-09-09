class Solution {
    public int majorityElement(int[] nums) {
        
        for(int i = 0; i < nums.length; i++)
        {
            int freq = 0;
            for(int j = 0; j < nums.length; j++)
            {
            if(nums[j] == nums[i] ){
            freq++;
            }
            else freq--; 
            } 
            if( freq > 0) return nums[i]; 
        }
        return -1;
    }
}