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
        int hp = 23;
        int cnt = 0;
        while(hp > 0){
            if(hp > 5){
                hp -= 5;
                cnt++;
            }
            else if(hp > 3){
                hp -= 3;
                cnt++;
            }
            else if(hp > 1){
                hp -= 1;
                cnt++;
            }
        }
        System.out.println(cnt);
//        ans.forEach((System.out::println));

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
