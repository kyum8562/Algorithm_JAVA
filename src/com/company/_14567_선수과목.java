package com.company;

import java.io.*;
import java.util.*;

public class _14567_선수과목 {
    static int N, M;
    static int[] ans;
    static List<Integer>[] list;
    static int[] degree;

    // 1. 각 노드마다 입력 수를 배열에 담아줌
    // 2. 0인 노드값들을 큐에 담아줌
    // 3. 큐에서 dequeue를 하고, T배열에 append함
    // 4. append한 값과 인접한 인덱스 값을 하나씩 --함
    // 5. 2번으로 이동
    // 6. 큐에 하나도 없을 경우 break;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N + 1];
        list = new ArrayList[N+1];
        ans = new int[N+1];

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            degree[b]++;
            list[a].add(b);
        }

        topologySort();

        for(int i = 1 ; i <= N ; i ++) System.out.print(ans[i] + " ");

    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();

        // 진입차수 0인값 큐에 넣기
        for(int i = 1 ; i <= N ; i ++){
            if(degree[i] == 0){
                q.offer(i);
                ans[i] = 1;
            }
        }

//        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int curr = q.poll();

            // 꺼낸 현재값을 T 배열에 넣어줌
//            sb.append(curr);

            // 현재값과 인접한 값들을 -1씩 해줌
            for(int i: list[curr]){
                degree[i]--;

                // 진입차수가 0인 값들은 큐에 넣어줌
                if(degree[i] == 0){
                    q.offer(i);
                    ans[i] = ans[curr] + 1;
                }
            }
        }
    }
}
