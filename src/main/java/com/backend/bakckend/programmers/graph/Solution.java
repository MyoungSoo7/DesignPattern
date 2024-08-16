package com.backend.bakckend.programmers.graph;

import java.util.*;

public class Solution {
    // 그래프를 표현하기 위한 Map
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구성
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0);
            String B = equation.get(1);
            double value = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }

        // 쿼리 처리
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String C = query.get(0);
            String D = query.get(1);
            results[i] = dfs(C, D, new HashSet<>(), 1.0);
        }

        return results;
    }

    private double dfs(String start, String end, Set<String> visited, double value) {
        // 노드가 그래프에 없는 경우
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        // 이미 방문한 노드인 경우
        if (visited.contains(start)) {
            return -1.0;
        }
        // 시작 노드와 끝 노드가 같은 경우
        if (start.equals(end)) {
            return value;
        }

        visited.add(start);

        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            double result = dfs(neighbor.getKey(), end, visited, value * neighbor.getValue());
            if (result != -1.0) {
                return result;
            }
        }

        visited.remove(start);
        return -1.0;
    }

    public static void main(String args) {
        Solution solution = new Solution();
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
