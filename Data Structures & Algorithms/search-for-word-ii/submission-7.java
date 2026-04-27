class TrieNode{
    Map<Character, TrieNode> children;
    String word = null;

    public TrieNode(){
        children = new HashMap<>();
    }
}

class Solution {

    char[][] fullboard = null;
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode node = root;

            for(Character c : word.toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }
                else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this.fullboard = board;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.children.containsKey(board[i][j])){
                    backtrack(i, j, root);
                }
            }
        }
        return ans;
    }

    private void backtrack(int row, int col, TrieNode parent){
        Character c = fullboard[row][col];
        TrieNode currNode = parent.children.get(c);

        while(currNode != null && currNode.word != null){
            this.ans.add(currNode.word);
            currNode.word = null;
        }

        fullboard[row][col] = '#';

        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++){
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if(newRow < 0 || newRow >= fullboard.length || newCol < 0 || newCol >= fullboard[0].length) continue;
            if(fullboard[newRow][newCol] != '#' && currNode.children.containsKey(fullboard[newRow][newCol])){
                backtrack(newRow, newCol, currNode);
            }
        }
        fullboard[row][col] = c;
    }
}
