import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 위상정렬 문제
 * 2252 줄세우기 - 기본
 * 2623 음악프로그램 - 기본
 * 1766 문제집 - 기본 + 우선순위큐
 * 1005 ACM Craft - 시간(가중치) 관리
 * 1516 게임 개발 - 시간(가중치) 관리
 * 3665 최종 순위 - 기본 + 간선 생성하기
 */
public class Main {
    static int N;
    static int[] tSortDegree, times, ans;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tSortDegree = new int[N + 1]; // 진입 차수가 담긴 배열
        list = new ArrayList[N + 1]; // 리스트 배열
        times = new int[N + 1]; // 건물별 시간이 담긴 배열

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            while(true){
                int num = Integer.parseInt(st.nextToken());

                if(num == -1) break;

                list[num].add(i);
                tSortDegree[i]++;
            }
        }

        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        ans = new int[N + 1]; // 최종 cost가 담긴 배열

        // 진출 차수가 0인 경우를 q에 모두 담아줌
        for (int i = 1; i <= N; i++) {
            if (tSortDegree[i] == 0) q.offer(i);
        }


        // 큐에 아무것도 없을때 까지 반복
        while (!q.isEmpty()) {
            int curr = q.poll();

            // 해당 노드에서 진출하는 노드들을 탐색하고, 해당 노드의 진입차수를 1 감소시킴
            for (int next : list[curr]) {
                ans[next] = Math.max(ans[curr] + times[curr], ans[next]);
                if (--tSortDegree[next] == 0) q.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) System.out.println(times[i]+ans[i]);
    }
}