import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] tSortDegree;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tSortDegree = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++) list[i] = new ArrayList<>();

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 리스트의 진입(a) 인덱스에 진출(b)를 담음
            list[a].add(b);
            // 진출 차수에 해당하는 인덱스 값을 +1 해줌
            tSortDegree[b] ++;
        }

        topologySort();
        System.out.println(sb);
    }
    private static void topologySort(){
        Queue<Integer> q = new ArrayDeque<>();

        // 진출 차수가 0인 경우를 q에 모두 담아줌
        for(int i = 1 ; i <= N ; i ++)
            if(tSortDegree[i] == 0) q.offer(i);

        // 큐에 아무것도 없을때 까지 반복
        while(!q.isEmpty()){
            int curr = q.poll();

            // 큐에 값을 꺼낸다는 뜻은, 순서대로 정렬이 이루어진다는 뜻이기 때문에 sb에 append해줌
            sb.append(curr).append(" ");

            // 해당 노드에서 진출하는 노드들을 탐색하고, 해당 노드의 진입차수를 1 감소시킴
            for(int next: list[curr]){
                if(--tSortDegree[next] == 0) q.offer(next);
            }
        }
    }
}