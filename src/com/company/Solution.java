package com.company;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String[] arr = br.readLine().split(" ");
            int ans1 = Integer.MAX_VALUE;
            int ans2 = Integer.MIN_VALUE;

            for(int i = 0 ; i < N ; i ++){
                ans1 = Math.min(ans1 , Integer.parseInt(arr[i]));
                ans2 = Math.max(ans2 , Integer.parseInt(arr[i]));
            }
        System.out.println(ans1+" "+ ans2);

    }
}
