package com.company;

import java.io.*;
import java.util.*;

public class _20040_사이클게임UF {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i = 1 ; i <= N ; i ++) parent[i] = i;


        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 1;
            int b = Integer.parseInt(st.nextToken()) + 1;

            // 부모가 같은지 검사하고 같다면 i 리턴
            if(sameParent(a, b)){
                System.out.println(i);
                return;
            }

            union(a, b);
        }

        System.out.println(0);
    }

    // 부모 찾기
    private static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    // 합집합
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
    // 부모가 같은지 검사
    private static boolean sameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return true;
        else return false;
    }

}
