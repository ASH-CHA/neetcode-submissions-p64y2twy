class Solution {
    public int lengthOfLIS(int[] nums) {
        // O(n^2) approach
        int[] Lis = new int[nums.length];
        Arrays.fill(Lis, 1);
        int max = 1;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    Lis[i] = Math.max(Lis[i], 1 + Lis[j]);
                    max = Math.max(max, Lis[i]);
                }
            }
        }
        return max;

        // O(n log(n)) approach
        /*if(nums.length == 0) return 0;

        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > sub.get(sub.size() - 1)){
                sub.add(nums[i]);
            }
            else{
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }
        return sub.size();*/
    }

    /*private int binarySearch(List<Integer> sub, int num){
        int left = 0;
        int right = sub.size() - 1;

        while(left < right){
            int mid = (left + right) - 1;

            if(sub.get(mid) == num) return sub.get(mid);
            else if(sub.get(mid) < num) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }*/
}
