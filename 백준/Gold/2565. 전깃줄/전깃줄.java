import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int l;
        int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            if (this.l < o.l) return -1;
            else if (this.l > o.l) return 1;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE;

        int[] DP = new int[501];
        Node[] a = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            if (DP[i] == 0) DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i].r > a[j].r) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(N - ans);
    }
}