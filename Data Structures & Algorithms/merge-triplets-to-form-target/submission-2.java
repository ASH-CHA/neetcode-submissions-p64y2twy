class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValue = new int[3];

        for(int[] triplet : triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                maxValue[0] = Math.max(maxValue[0], triplet[0]);
                maxValue[1] = Math.max(maxValue[1], triplet[1]);
                maxValue[2] = Math.max(maxValue[2], triplet[2]);
            }
        }
        return maxValue[0] == target[0] && maxValue[1] == target[1] && maxValue[2] == target[2];
    }
}