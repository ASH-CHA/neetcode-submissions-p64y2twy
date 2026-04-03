class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[27];
        isEnd = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root){
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(c == '.'){
                for(var x : curr.children){
                    if(x != null && search(word.substring(i + 1), x)) return true;
                }
                return false;
            }
            else if(curr.children[c - 'a'] != null){
                curr = curr.children[c - 'a'];
            }
            else return false;
        }
        return curr.isEnd;
    }
}
