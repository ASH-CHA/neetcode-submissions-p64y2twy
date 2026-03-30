class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> intm = new ArrayList<>();

        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while(i < intervals.length && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        ans.add(Arrays.asList(start, end));

        while(i < intervals.length){
            ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            i++;
        }

        int[][] res = new int[ans.size()][2];
        for(int j = 0; j < ans.size(); j++){
            res[j][0] = ans.get(j).get(0);
            res[j][1] = ans.get(j).get(1);
        }
        return res;
    }
}
