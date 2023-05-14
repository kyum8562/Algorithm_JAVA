package com.company;

import java.io.*;
import java.util.*;

public class _N과M9_ {
    static int[] arr, arr2;
    static int N, M;
    static boolean[] v;
    static Set<String> ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        arr2 = new int[M];
        v = new boolean[N];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        perm(0);

//        ans.forEach((System.out::println));
        for(String s : ans)
            System.out.println(s);
    }

    private static void perm(int cnt) {
        if(cnt == M){
            sb = new StringBuilder();
            for(int i : arr2)
                sb.append(i + " ");
            ans.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < N ; i ++){
            if(v[i]) continue;
            v[i] = true;
            arr2[cnt] = arr[i];
            perm(cnt+1);
            v[i] = false;
        }
    }
}