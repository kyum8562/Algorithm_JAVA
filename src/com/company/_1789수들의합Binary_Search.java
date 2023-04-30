package com.company;

import java.io.*;
import java.util.*;

public class _1789수들의합Binary_Search {
    static long N;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());

        binary_search(1, N);
        System.out.println(ans);
    }

    private static void binary_search(long start, long end) {
        if(start > end) return;

        long mid = (start + end) / 2;
        long sum = calcSum(mid);
        if(sum > N){
            binary_search(start, mid - 1);
        }
        else if(sum < N){
            ans = Math.max(ans, mid);
            binary_search(mid + 1, end);
        }
        else{
            ans = mid;
            return;
        }
    }

    private static long calcSum(long mid) {
        return (mid)*(mid+1)/2;
    }
}


