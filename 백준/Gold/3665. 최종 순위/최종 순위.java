import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 위상정렬 문제
 * 2252 줄세우기 - 기본
 * 2623 음악프로그램 - 기본
 * 1766 문제집 - 기본 + 우선순위큐
 * 1005 ACM Craft -
 * 3665 최종 순위 -
 */
public class Main {
    static int N, M;
    static int[] tSortDegree;
    static List<Integer>[] list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            N = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            tSortDegree = new int[N + 1];
            list = new ArrayList[N + 1];
            int[] arr = new int[N + 1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            // 입력 받은 작년 순위를 arr에 저장한다
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 본인 노드 이하의 순위는 다 간선을 연결해준다
            for (int i = 1; i <= N; i++){
                for (int j = i+1; j <= N; j++){
                    list[arr[i]].add(arr[j]);
                    tSortDegree[arr[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 작년 순위에 포함되는 순위라면
                if(list[a].contains(b)){
                    list[a].remove((Integer) b);
                    list[b].add(a);

                    tSortDegree[a] ++;
                    tSortDegree[b] --;
                }
                else{
                    list[b].remove((Integer) a);
                    list[a].add(b);

                    tSortDegree[b] ++;
                    tSortDegree[a] --;
                }
            }

            topologySort();
        }
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();

        // 진출 차수가 0인 경우를 q에 모두 담아줌
        for (int i = 1; i <= N; i++)
            if (tSortDegree[i] == 0) q.offer(i);
        // 큐에 아무것도 없을때 까지 반복
        while (!q.isEmpty()) {
            if(q.size() > 1){
                System.out.println("?");
                return;
            }

            int curr = q.poll();

            // 큐에 값을 꺼낸다는 뜻은, 순서대로 정렬이 이루어진다는 뜻이기 때문에 sb에 append해줌
            sb.append(curr).append(" ");

            // 해당 노드에서 진출하는 노드들을 탐색하고, 해당 노드의 진입차수를 1 감소시킴
            for (int next : list[curr]) {
                if (--tSortDegree[next] == 0) q.offer(next);
            }
        }

        // 사이클이 존재하는지 판단 -> 위상정렬을 마치고나서 tSortDegree의 인덱스 값들 중 0이 아닌것이 있다면 사이클
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (tSortDegree[i] != 0) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.println(sb);
        else System.out.println("IMPOSSIBLE");
        // 확실한 순위를 찾을 수 없다면 ? 출력해야 함
    }
}