package com.company;

import java.io.*;
import java.util.*;

public class _2018_수들의합 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int ans = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right <= N) {

            // 같을 때
            if (sum == N){
                ans++;

                sum -= left;
                left++;
                right++;
                sum += right;
            }
            // 클 때
            else if (sum > N){
                sum -= left;
                left++;
            }
            // 작을 때
            else{
                right++;
                sum += right;
            }
        }
        System.out.println(ans);
    }
}
