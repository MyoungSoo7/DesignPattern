package com.backend.bakckend.programmers.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MineralMining {

    public static int solution(int[] picks, String[] minerals) {
        return IntStream.iterate(0, i -> i < Math.min(minerals.length, Arrays.stream(picks).sum() * 5), i -> i + 5)
                .mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
                        .mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
                .sorted((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum())
                .mapToInt(arr -> {
                    int n = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
                    return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();})
                .sum();
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};  // 다이아몬드, 철, 돌 곡괭이 개수
        String[] minerals = {"diamond", "iron", "stone", "diamond", "iron", "stone", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));  // 최소 피로도 출력
    }
}
