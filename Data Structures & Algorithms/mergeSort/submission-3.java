// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if(pairs.size() <= 1) return pairs;

        int mid = pairs.size() / 2;

        List<Pair> left = mergeSort(new ArrayList<>(pairs.subList(0, mid)));
        List<Pair> right = mergeSort(new ArrayList<>(pairs.subList(mid, pairs.size())));

        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right){
        List<Pair> res = new ArrayList<>();
        int i = 0, j = 0;

        while(i < left.size() && j < right.size()){
            if(left.get(i).key <= right.get(j).key){
                res.add(left.get(i));
                i++;
            }
            else{
                res.add(right.get(j));
                j++;
            }
        }

        while(i < left.size()){
            res.add(left.get(i));
            i++;
        }

        while(j < right.size()){
            res.add(right.get(j));
            j++;
        }
        return res;
    }
}