// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        if(pairs == null || pairs.size() <= 1) return pairs;

        quickHelperSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    private void quickHelperSort(List<Pair> pairs, int low, int high){
        if(low < high){
            int pivotIndex = partition(pairs, low, high);
            quickHelperSort(pairs, low, pivotIndex - 1);
            quickHelperSort(pairs, pivotIndex + 1, high);
        }
    }

    private int partition(List<Pair> pairs, int low, int high){
        Pair curr = pairs.get(high);
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(pairs.get(j).key < curr.key){
                i++;
                swap(pairs, i, j);
            }
        }
        swap(pairs, i + 1, high);
        return i + 1;
    }

    private void swap(List<Pair> pairs, int i, int j){
        Pair temp = pairs.get(i);
        pairs.set(i, pairs.get(j));
        pairs.set(j, temp);
    }
}