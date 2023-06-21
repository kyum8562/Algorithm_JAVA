package com.company;

import java.io.*;
import java.util.*;

public class _20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] ans = new int[100001];
//        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        int first = 0;
        int end = 0;

        while (first <= end) {
//            int getCurrVal = map.getOrDefault(arr[end], 0);
//            if(end <= N-1 && getCurrVal < K){
//                map.put(arr[end],  getCurrVal + 1);
//                end++;
//            }
//            else if(getCurrVal == K){
//                map.put(arr[first],  getCurrVal - 1);
//                first++;
//            }
            if(end <= N-1 && ans[arr[end]] < K){
                ans[arr[end]]++;
                end++;
            }
            else if(ans[arr[end]] == K){
                ans[arr[first]]--;
                first++;
            }

            result = Math.max(end-first, result);

            if(end == N) break;
        }

        System.out.println(result);
    }
}
