package tree;

import java.util.HashMap;

class TrieNode {

    private boolean ending;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
        ending = false;
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }

    public void setChild(char c, TrieNode child) {
        children.put(c, child);
    }

    public boolean isEnding() {
        return ending;
    }

    public void setEnding(boolean ending) {
        this.ending = ending;
    }
}

//class TrieNode {
//
//    private boolean ending;
//    private TrieNode[] children;
//
//    TrieNode() {
//        children = new TrieNode[26];
//        ending = false;
//    }
//
//    public TrieNode getChild(int i) {
//        return children[i];
//    }
//
//    public void setChild(int i, TrieNode child) {
//        children[i] = child;
//    }
//
//    public boolean isEnding() {
//        return ending;
//    }
//
//    public void setEnding(boolean ending) {
//        this.ending = ending;
//    }
//}
