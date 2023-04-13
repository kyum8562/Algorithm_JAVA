package com.company;

import java.io.*;
import java.util.*;

public class N과M9 {
    static int N, M;
    static int[] arr, arr2;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<String> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr2 = new int[M];
        visited = new boolean[N];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        perm(0);
        ans.forEach((System.out::println));

    }

    private static void perm(int cnt) {
        if(cnt == M){
            sb = new StringBuilder();
            for(int p : arr2)
                sb.append(p).append(" ");
            ans.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < N ; i ++){
            if(visited[i]) continue;
            visited[i] = true;
            arr2[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }

}
