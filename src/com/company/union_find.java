package com.company;

import java.io.IOException;

public class union_find {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        int N = 5;
        parent = new int[N + 1];

        for (int i = 0; i < parent.length; i++) parent[i] = i;

        union(1, 2);
        union(3, 4);
        parentPrint();
        union(2, 4);
        parentPrint();
        System.out.println(find(2));
    }

    private static void parentPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println("]");
    }

    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        // 부모가 동일
        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    private static int find(int x) {
        // 부모가 자기 자신일 경우
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}

