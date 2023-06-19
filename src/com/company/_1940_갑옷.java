package com.company;

import java.io.*;
import java.util.*;

public class _1940_갑옷 {
    static int N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++) map[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        int left = 1;
        int right = N;
        Arrays.sort(map);
        while(left < right){
            int sum = map[left] + map[right];
            if(sum == M){
                ans++;
                left++;
            }
            else if(sum > M) right--;
            else left++;
        }
        System.out.println(ans);
    }
}
