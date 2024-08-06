package com.backend.bakckend.leet;


import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    private List<String> commbinationList;
    private int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
        this.commbinationList = new ArrayList<>();
        this.index =0;
        dfs(characters, combinationLength, 0, new StringBuilder());
    }

    private void dfs(String characters, int combinationLength, int start, StringBuilder sb) {
        if (sb.length() == combinationLength) {
            commbinationList.add(sb.toString());
            return;
        }

        for (int i = start; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            dfs(characters, combinationLength, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        return commbinationList.get(index++);
    }

    public boolean hasNext() {
        return index < commbinationList.size();
    }

}
