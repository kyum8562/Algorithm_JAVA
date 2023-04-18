package com.company;

import java.io.*;
import java.util.*;

// https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1043-%EA%B1%B0%EC%A7%93%EB%A7%90-JAVA%EC%9E%90%EB%B0%94
public class _거짓말UnionFind {
    static int N, M, min = Integer.MAX_VALUE, cnt;
    static boolean[] knowPeople, v;
    static Queue<Integer> q;
    static int[] res, truthArr, parent;
    static List<List<Integer>> partyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 입력 : 사람의 수 N과 파티의 수 M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력 : 이야기의 진실을 아는 사람의 수와 번호
        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 수가 0일 경우 이후 연산 필요없음
        if(truthCnt == 0){
            System.out.println(M);
            return;
        }

        // 자신과 연결된 루트 노드를 설정
        parent = new int[N + 1];
        for(int i = 1 ; i <= N ; i ++) parent[i] = i;

        // 진실을 아는 사람들의 배열
        knowPeople = new boolean[N+1];
        for(int i = 0 ; i < truthCnt ; i ++){
            knowPeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 파티에 참여한 사람들의 목록 생성
        partyList = new ArrayList<>();
        for(int i = 0 ; i < M ; i ++)
            partyList.add(new ArrayList<>());

        // 입력 : 진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int manCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < manCnt; j++) {
                partyList.get(i).add(Integer.parseInt(st.nextToken()));

                // 같이 파티에 참가한 사람 확인 => 진실을 아는사람들과 같이 파티를 갔는지 확인
                // 이후 같이 간사람들 제외한 다른 파티의 개수를 세어 출력해 줄 것임
                if(j != 0){
                    int a = partyList.get(i).get(j);
                    int b = partyList.get(i).get(j-1);

                    union(b, a);
                }
            }
        }

        v = new boolean[N+1];
        for(int i = 1 ; i <= N ; i ++){
            if(knowPeople[i] && !v[i]){
                int parent = find(i);

                for(int j = 1 ; j <= N ; j ++){
                    if(find(j) == parent){
                        knowPeople[j] = true;
                        v[j] = true;
                    }
                }
            }
        }

        // 파티에 진실을 아는 사람이 있는지 확인
        boolean[] goParty = new boolean[M];
        for(int i = 0 ; i < M ; i ++)
            goParty[i] = true;

        for(int i = 0 ; i < M ; i ++){
            for(int j = 0 ; j <= N ; j ++){
                if(knowPeople[j] && partyList.get(i).contains(j))
                    goParty[i] = false;
            }
        }

        int sum = 0;
        for(int i = 0 ; i < M ; i ++)
            if(goParty[i]) sum++;

        System.out.println(sum);

    }
    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    private static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }

}


