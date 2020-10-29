package tree;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int n = word.length();
        TrieNode p = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (p.getChild(c) == null) {
                p.setChild(c, new TrieNode());
            }
            p = p.getChild(c);
        }
        p.setEnding(true);
    }

    /**
     * @return if the word is in the trie.
     */
    public boolean search(String word) {
        int n = word.length();
        TrieNode p = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (p.getChild(c) == null) {
                return false;
            }
            p = p.getChild(c);
        }
        return p.isEnding();
    }

    /**
     * @return if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode p = root;
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (p.getChild(c) == null) {
                return false;
            }
            p = p.getChild(c);
        }
        return true;
    }

}
