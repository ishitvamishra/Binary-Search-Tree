class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num: nums){
            arr.add(num);
        }
        for(int i = 0;i<nums.length;i++){
            int count = Collections.frequency(arr, nums[i]);
            if(count == n){
                return nums[i];
            }
        }

        return 0;
    }
}