// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> ans = new ArrayList<>();

        for(int i = 0; i < pairs.size(); i++){
            Pair curr = pairs.get(i);
            int j = i - 1;

            while(j >= 0 && pairs.get(j).key > curr.key){
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            pairs.set(j + 1, curr);
            ans.add(new ArrayList<>(pairs));
        }
        return ans;
    }
}