class Solution {

    class TrieNode{
        Map<Character, TrieNode> children;
        String word = null;

        public TrieNode(){
            children = new HashMap<>();
        }
    }

    private char[][] fullboard;
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode node = root;

            for(char c : word.toCharArray()){
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

    private void backtrack(int row, int col, TrieNode parentNode){
        char c = fullboard[row][col];
        TrieNode currNode = parentNode.children.get(c);

        while(currNode != null && currNode.word != null){
            this.ans.add(currNode.word);
            currNode.word = null;
        }

        fullboard[row][col] = '#';
        int[] rowOffSet = {0, 1, 0, -1};
        int[] colOffSet = {-1, 0, 1, 0};

        for(int i = 0; i < 4; i++){
            int nr = row + rowOffSet[i];
            int nc = col + colOffSet[i];

            if(0 > nr || nr >= fullboard.length || 0 > nc || nc >= fullboard[0].length){
                continue;
            }
            if(fullboard[nr][nc] != '#' && currNode.children.containsKey(fullboard[nr][nc])){
                backtrack(nr, nc, currNode);
            }
        }
        fullboard[row][col] = c;
    }
}