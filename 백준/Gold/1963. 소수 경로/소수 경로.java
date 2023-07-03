import java.io.*;
import java.util.*;

public class Main {
    static int start, end, ans;
    static int[] cnt;
    static boolean[] v, isPrime;

    static class Node {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        isPrime = new boolean[10000];
        isPrimeFunc();

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            cnt = new int[10000];
            v = new boolean[10000];
            st = new StringTokenizer(br.readLine());

            ans = Integer.MAX_VALUE;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(cnt[end]);
        }
    }

    private static void isPrimeFunc() {
        for (int i = 1001; i <= 9999; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                isPrime[i] = true;
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        v[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < 10; i++) {
                    if(d==0 && i==0) continue;

                    int nr = change(curr, d, i);

                    if(isPrime[nr] && !v[nr]){
                        v[nr] = true;
                        cnt[nr] = cnt[curr] + 1;
                        q.offer(nr);
                    }
                }
            }
        }
    }
    // 특정 자릿수를 들어온 값으로 바꾸기 위한 함수
    public static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num)); // int를 stringBuilder로 바꿈
        sb.setCharAt(i, (char) (j + '0')); //(인덱스, 바꿀문자)  (char) (v + '0') = int v를 문자 v로 만듬
        return Integer.parseInt(sb.toString()); // 그냥 sb 하면 안되는 이유는 괄호안에 타입이 string이기 때문

    }
}