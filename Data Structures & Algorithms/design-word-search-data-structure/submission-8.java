class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[27];
        isEnd = false;
    }
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root){
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            while(c == '.'){
                for(var x : curr.children){
                    if(x != null && search(word.substring(i + 1), x)) return true;
                }
                return false;
            }
            if(curr.children[c - 'a'] != null) curr = curr.children[c - 'a'];
            else return false;
        }
        return curr.isEnd;
    }
}
