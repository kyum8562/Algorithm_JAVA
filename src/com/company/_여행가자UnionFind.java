package com.company;

import java.io.*;
import java.util.*;

public class _여행가자UnionFind {
    static int N, M;
    static int[] parent, plan;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 수
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 여행 계획에 속한 도시들의 수
        parent = new int[N + 1];
        plan = new int[N];
        map = new int[N + 1][N + 1];

        makeSet();

        // map 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int go = Integer.parseInt(st.nextToken());

                if (go == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획
        boolean flag = true;
        st = new StringTokenizer(br.readLine());
        int root = find(parent[Integer.parseInt(st.nextToken())]);
        while (M-- > 1) {
            if (root != find(parent[Integer.parseInt(st.nextToken())])) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) return false;
        else return true;
    }

    private static void makeSet() {
        for (int i = 1; i <= N; i++)
            parent[i] = i;
    }

}
