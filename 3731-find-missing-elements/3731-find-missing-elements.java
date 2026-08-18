class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0;

        for(int i = 0; i<nums.length-1; i++){
            int point = nums[i];
            while(nums[i+1] - point !=1){
                list.add(++point);
            }
        }
        return list;
    }
}