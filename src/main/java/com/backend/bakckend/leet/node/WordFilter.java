package com.backend.bakckend.leet.node;

import java.util.HashMap;
import java.util.Map;

class WordFilter {
    private TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            String key = word + "{" + word;
            for (int i = 0; i < word.length(); i++) {
                TrieNode node = root;
                for (int j = i; j < 2 * word.length() + 1; j++) {
                    char c = key.charAt(j);
                    if (!node.children.containsKey(c)) {
                        node.children.put(c, new TrieNode());
                    }
                    node = node.children.get(c);
                    node.depth = index;
                }
            }
        }
    }

    public int f(String pref, String suff) {
        TrieNode node = root;
        String key = suff + "{" + pref;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return -1;
            }
            node = node.children.get(c);
        }
        return node.depth;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        int depth;

        TrieNode() {
            children = new HashMap<>();
            depth = -1;
        }
    }
}

