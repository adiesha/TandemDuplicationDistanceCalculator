package org.msu.adiesha.utils;

import java.util.Stack;

public class TopologicalSort {


    public static Stack<Integer> topoSort(int v, int[][] adjMatrix) {
        Stack<Integer> result = new Stack<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                topoSort(i, adjMatrix, visited, result);
        }

        return result;
    }

    public static void topoSort(int i, int[][] matrix, boolean[] visited, Stack<Integer> result) {
        visited[i] = true;

        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] >= 1 && i != j && !visited[j]) {
                topoSort(j, matrix, visited, result);
            }
        }

        result.push(i);
    }
}
